import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {
    private final int port;
    private final ExecutorService pool = Executors.newCachedThreadPool();
    private final Set<Handler> clients = new HashSet<>();


    private EchoServer(int port) {
        this.port = port;
    }

    public static EchoServer bindToPort(int port) {
        return new EchoServer(port);
    }

    public void run() {
        try (var server = new ServerSocket(port)) {
            while(true) {
                Socket clientSocket = server.accept();
                Handler handler = new Handler(clientSocket, this);
                synchronized (clients){
                    clients.add(handler);
                }
                pool.submit(handler);
            }
        } catch (IOException e) {
            var formatMsg = "Вероятнее всего порт %s занят.%n";
            System.out.printf(formatMsg, port);
            e.printStackTrace();
        }
    }

    public void cast(String name, String msg, Handler sender) {
        synchronized (clients) {
            for (Handler client : clients) {
                if (client != sender){
                    client.send(name + ": " + msg);
                }
            }
        }
    }

    public void remove(Handler client) {
        synchronized (clients) {
            clients.remove(client);
        }
    }


}
