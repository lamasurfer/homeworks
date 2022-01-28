package org.example.task2;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        final String ip = "127.0.0.1";
        final int port = 8082;

        InetSocketAddress address = new InetSocketAddress(ip, port);

        NIOServer nioServer = new NIOServer(address);
        NIOClient nioClient = new NIOClient(address);

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(nioServer::start);
        service.execute(nioClient::start);

        service.shutdown();
    }
}
