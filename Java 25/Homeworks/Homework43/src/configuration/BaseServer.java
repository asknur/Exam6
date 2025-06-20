package configuration;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class BaseServer {

    public static HttpServer makeServer() throws IOException {
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8089);
        System.out.printf("Запускаем сервер по адресу 'http://%s:%s'%n", address.getHostName(), address.getPort());
        HttpServer server = HttpServer.create(address, 50); //creating server
        System.out.println("      удачно!");
        return server;
    }

    public static HttpServer makeServer2() throws IOException {
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9889);
        System.out.printf("Запускаем сервер по адресу 'http://%s:%s'%n", address.getHostName(), address.getPort());
        HttpServer server = HttpServer.create(address, 50); //creating server
        System.out.println("      удачно!");
        return server;
    }
}