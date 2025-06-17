import java.io.*;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Handler implements Runnable {
    private final Socket socket;
    private final EchoServer server;
    private PrintWriter writer;
    private static int num = 1;
    private final String name = "User" + num++;



    public Handler(Socket socket, EchoServer server){
        this.socket = socket;
        this.server = server;
    }

    public void run() {
        System.out.printf("Подключен клиент: %s%n", socket);
        try (socket;
             Scanner reader = getReader(socket);
             PrintWriter writer = getWriter(socket)) {
            this.writer = writer;
            send("Привет " + name);
            while (true) {
                String message = reader.nextLine();
                if (isEmptyMsg(message) || isQuitMsg(message)) {
                    break;
                }
                server.cast(name, message.toUpperCase(), this);
            }
        } catch (NoSuchElementException ex) {
            System.out.println("Клиент закрыл соединение!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            server.remove(this);
        }
        System.out.printf("Клиент отключен: %s%n", socket);
    }

    private static PrintWriter getWriter(Socket socket) throws IOException {
        return new PrintWriter(socket.getOutputStream(), true);
    }

    private static Scanner getReader(Socket socket) throws IOException {
        return new Scanner(new InputStreamReader(socket.getInputStream(), "UTF-8"));
    }

    private static boolean isQuitMsg(String message) {
        return "bye".equalsIgnoreCase(message);
    }

    private static boolean isEmptyMsg(String message) {
        return message == null || message.isBlank();
    }

    private static void sendResponse(String response, Writer writer) throws IOException {
        writer.write(response);
        writer.write(System.lineSeparator());
        writer.flush();
    }

    void send(String msg) {
        writer.println(msg);
    }
}
