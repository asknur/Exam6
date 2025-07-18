package kg.attractor.java.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public abstract class BasicServer {

    private final HttpServer server;
    // путь к каталогу с файлами, которые будет отдавать сервер по запросам клиентов
    private final String dataDir = "data";
    private Map<String, RouteHandler> routes = new HashMap<>();

    protected BasicServer(String host, int port) throws IOException {
        server = createServer(host, port);
        registerCommonHandlers();
    }

    private static String makeKey(String method, String route) {
        return String.format("%s %s", method.toUpperCase(), route);
    }

    private static String makeKey(HttpExchange exchange) {
        var method = exchange.getRequestMethod();
        var path = exchange.getRequestURI().getPath();

        var index = path.lastIndexOf(".");
        var extOrPath = index != -1 ? path.substring(index).toLowerCase() : path;

        return makeKey(method, extOrPath);
    }

    private static void setContentType(HttpExchange exchange, ContentType type) {
        exchange.getResponseHeaders().set("Content-Type", String.valueOf(type));
    }

    private static HttpServer createServer(String host, int port) throws IOException {
        var msg = "Starting server on http://%s:%s/%n";
        System.out.printf(msg, host, port);
        var address = new InetSocketAddress(host, port);
        return HttpServer.create(address, 50);
    }

    private void registerCommonHandlers() {
        // самый основной обработчик, который будет определять
        // какие обработчики вызывать в дальнейшем
        server.createContext("/", this::handleIncomingServerRequests);

        // специфичные обработчики, которые выполняют свои действия
        // в зависимости от типа запроса

        // обработчик для корневого запроса
        // именно этот обработчик отвечает что отображать,
        // когда пользователь запрашивает localhost:9889
        registerGet("/", exchange -> sendFile(exchange, makeFilePath("index.html"), ContentType.TEXT_HTML));

        // эти обрабатывают запросы с указанными расширениями
        registerFileHandler(".css", ContentType.TEXT_CSS);
        registerFileHandler(".html", ContentType.TEXT_HTML);
        registerFileHandler(".jpg", ContentType.IMAGE_JPEG);
        registerFileHandler(".png", ContentType.IMAGE_PNG);

    }

    protected final void registerGet(String route, RouteHandler handler) {
        getRoutes().put("GET " + route, handler);
    }

    protected final void registerPost(String route, RouteHandler handler) {
        getRoutes().put("POST " + route, handler);
    }


    protected final void registerFileHandler(String fileExt, ContentType type) {
        registerGet(fileExt, exchange -> sendFile(exchange, makeFilePath(exchange), type));
    }

    protected final Map<String, RouteHandler> getRoutes() {
        return routes;
    }

    protected final void sendFile(HttpExchange exchange, Path pathToFile, ContentType contentType) {
        try {
            if (Files.notExists(pathToFile)) {
                respond404(exchange);
                return;
            }
            var data = Files.readAllBytes(pathToFile);
            sendByteData(exchange, ResponseCodes.OK, contentType, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Path makeFilePath(HttpExchange exchange) {
        return makeFilePath(exchange.getRequestURI().getPath());
    }

    protected Path makeFilePath(String... s) {
        return Path.of(dataDir, s);
    }

    protected final void sendByteData(HttpExchange exchange, ResponseCodes responseCode,
                                      ContentType contentType, byte[] data) throws IOException {
        try (var output = exchange.getResponseBody()) {
            setContentType(exchange, contentType);
            exchange.sendResponseHeaders(responseCode.getCode(), 0);
            output.write(data);
            output.flush();
        }
    }

    private void respond404(HttpExchange exchange) {
        try {
            var data = "404 Not found".getBytes();
            sendByteData(exchange, ResponseCodes.NOT_FOUND, ContentType.TEXT_PLAIN, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void redirect303(HttpExchange exchange, String path){
        try{
            exchange.getResponseHeaders().add("Location", path);
            exchange.sendResponseHeaders(ResponseCodes.REDIRECT_303.getCode(), 0);
            exchange.getResponseBody().close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void handleIncomingServerRequests(HttpExchange exchange) throws IOException {
        var route = getRoutes().getOrDefault(makeKey(exchange), this::respond404);
        route.handle(exchange);
    }

    public final void start() {
        server.start();
    }

    protected String getContentType(HttpExchange exchange){
         return exchange.getRequestHeaders().getOrDefault("Content-Type", List.of("")).get(0);
    }

    protected String getBody(HttpExchange exchange){
        InputStream in = exchange.getRequestBody();
        Charset utf8 = StandardCharsets.UTF_8;
        InputStreamReader isr = new InputStreamReader(in, utf8);
        try(BufferedReader reader = new BufferedReader(isr)) {
            return reader.lines().collect(Collectors.joining(""));
        } catch (IOException e){
            e.printStackTrace();
        }
        return "";
    }

    protected void setCookie(HttpExchange exchange, Cookie cookie){
        exchange.getResponseHeaders().add("Set-Cookie", cookie.toString());
    }

    protected String getCookies(HttpExchange exchange){
        return exchange.getRequestHeaders().getOrDefault("Cookie", List.of("")).get(0);
    }

    protected Map<String, String> getQueryParams(HttpExchange exchange) {
        String query = exchange.getRequestURI().getQuery();
        if (query == null || query.isEmpty()) {
            return Collections.emptyMap();
        }

        return Arrays.stream(query.split("&"))
                .map(param -> param.split("="))
                .filter(pair -> pair.length == 2)
                .collect(Collectors.toMap(
                        pair -> URLDecoder.decode(pair[0], StandardCharsets.UTF_8),
                        pair -> URLDecoder.decode(pair[1], StandardCharsets.UTF_8)
                ));
    }

    protected Map<String, String> parseFormData(HttpExchange exchange) throws IOException {
        String rawData = getBody(exchange); // Используем существующий метод getBody
        if (rawData == null || rawData.isEmpty()) {
            return Collections.emptyMap();
        }

        return Arrays.stream(rawData.split("&"))
                .map(param -> param.split("="))
                .filter(pair -> pair.length == 2)
                .collect(Collectors.toMap(
                        pair -> URLDecoder.decode(pair[0], StandardCharsets.UTF_8),
                        pair -> URLDecoder.decode(pair[1], StandardCharsets.UTF_8)
                ));
    }




}
