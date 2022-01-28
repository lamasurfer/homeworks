package org.example.task1;

public class Main {
    public static void main(String[] args) {

        final int port = 8081;
        final String host = "127.0.0.1";


        Thread serverThread = new Thread(() -> {
            final Server server = new Server();
            server.start(port);
            String received = server.readMessage();
            System.out.println("Server received: " + received);
            server.sendTaskMessage(received);
            String received2 = server.readMessage();
            System.out.println("Server received: " + received2);
            server.stop();
        });


        Thread clientThread = new Thread(() -> {
            final Client client = new Client();
            client.start(host, port);
            client.sendMessage("Client");
            String received = client.readMessage();
            System.out.println("Client received: " + received);
            client.sendMessage("Cool! Thank you!");
            client.stop();

        });

        serverThread.start();
        clientThread.start();

    }
}
