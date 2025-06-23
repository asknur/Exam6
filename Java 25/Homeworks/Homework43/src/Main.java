import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import configuration.BaseServer;

import java.io.*;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        try{
            HttpServer server = BaseServer.makeServer();
            initRoutes(server);
            server.start();

            HttpServer server2 = BaseServer.makeServer2();
            initRoutes(server2);
            server2.start();
        } catch (IOException e){
            e.printStackTrace();
        }
    }



    private static void initRoutes(HttpServer server){
        server.createContext("/", Main::handleRootReaquest);
        server.createContext("/apps/", Main::handleAppsReaquest);
        server.createContext("/apps/profile", Main::handleProfileReaquest);
        server.createContext("/index.html", Main::handleFiles);

    }



    private static void handleReaquestCustom(HttpExchange exchange, String message) {
        try {
            exchange.getResponseHeaders().add("Content-Type", "text/plain; charset=utf-8");
            int responseCode = 200;
            int lenght = 0;
            exchange.sendResponseHeaders(responseCode, lenght);

            try(PrintWriter writer = getWriterFrom(exchange)) {
                String method = exchange.getRequestMethod();
                URI uri = exchange.getRequestURI();
                String path = exchange.getHttpContext().getPath();

                write(writer, "HTTP Method", method);
                write(writer, "Request", uri.toString());
                write(writer, "Handled", path);
                write(writer, "Message: ", message);

                writeHeaders(writer, "Request headers", exchange.getRequestHeaders());
                writeData(writer, exchange);
                writer.flush();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void handleRootReaquest(HttpExchange exchange){
        handleReaquestCustom(exchange, "Hello. you are welcome to the HOME page!");
    }

    private static void handleAppsReaquest(HttpExchange exchange){
        handleReaquestCustom(exchange, "Hello. you are welcome to the APPS page!");
    }

    private static void handleProfileReaquest(HttpExchange exchange){
        handleReaquestCustom(exchange, "Hello. you are welcome to the PROFILES page!");
    }

    private static void handleFiles(HttpExchange exchange) {
        try {
            URI uri = exchange.getRequestURI();
            String path = uri.getPath();
            File file = new File("static", path);

            if (!file.exists() || file.isDirectory()) {
                String response = "404: файл не найден";
                exchange.sendResponseHeaders(404, response.length());
                exchange.getResponseBody().write(response.getBytes());
                exchange.close();
                return;
            }

            String contentType = guessContentType(file.getName());
            exchange.getResponseHeaders().add("Content-Type", contentType);
            exchange.sendResponseHeaders(200, file.length());

            try (OutputStream os = exchange.getResponseBody();
                 FileInputStream fs = new FileInputStream(file)) {
                fs.transferTo(os);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static String guessContentType(String filename) {
        if (filename.endsWith(".html")) return "text/html; charset=utf-8";
        if (filename.endsWith(".css")) return "text/css; charset=utf-8";
        if (filename.endsWith(".js")) return "application/javascript; charset=utf-8";
        return "application/octet-stream";
    }



    private static void writeHeaders(Writer writer, String type, Headers headers) {
        write(writer, type, "");
        headers.forEach((key, value) -> write(writer,"\t" + key, value.toString()));
    }



    private static void write(Writer writer, String msg, String method) {
        String data = String.format("%s: %s%n%n", msg, method);
        try {
            writer.write(data);
        } catch (IOException e){
            e.printStackTrace();
        }
    }



    private static PrintWriter getWriterFrom(HttpExchange exchange) {
        OutputStream os = exchange.getResponseBody();
        Charset charset = StandardCharsets.UTF_8;
        return new PrintWriter(os, false, charset);
    }



    private static BufferedReader getReader(HttpExchange exchange) {
        InputStream input = exchange.getRequestBody();
        Charset charset = StandardCharsets.UTF_8;
        InputStreamReader isr = new InputStreamReader(input, charset);
        return new BufferedReader(isr);
    }



    private static void writeData(Writer writer, HttpExchange exchange) {
        try (BufferedReader reader = getReader(exchange)) {
            if (!reader.ready()) {
                return;
            }
            write(writer, "Блок данных", "");
            reader.lines().forEach(v -> write(writer, "\t", v));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}