package org.example.task1;

import org.example.task1.javacore_osi.Client;
import org.example.task1.javacore_osi.Server;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        final String ip = "127.0.0.1";
        final int port = 8081;

        // Blocking т.к. нужно дождаться выполнения результата
        Server fibonacciServer = new FibonacciServer(port);
        Client fibonacciClient = new FibonacciClient(ip, port, new Scanner(System.in));

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(fibonacciServer::start);
        service.execute(fibonacciClient::start);

        service.shutdown();

    }
}
