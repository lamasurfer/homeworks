package org.example.task2;

public class Main {
    public static void main(String[] args) {


        final CityGame cityGame = new CityGame();
        final int port = 8082;
        final String host = "netology.homework";


        Thread serverThread = new Thread(() -> {
            final Server server = new Server(cityGame);
            server.start(port);
            server.sendMessage("Lets play CityGame!");
            server.readMessage();
            server.playGame();
            server.stop();
        });


        Thread clientThread = new Thread(() -> {
            final Client client = new Client(cityGame);
            client.start(host, port);
            client.readMessage();
            client.sendMessage("Ok! Start!");
            client.playGame();
            client.stop();
        });

        serverThread.start();
        clientThread.start();
        
    }
}
