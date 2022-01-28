package org.example.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class Client {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private final CityGame cityGame;

    public Client(CityGame cityGame) {
        this.cityGame = cityGame;
    }

    public void start(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            System.out.println("Player#2: joined");
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playGame() {
        String temp;
        boolean victorious = false;
        while ((temp = readMessage()) != null) {
            if (temp.contains("out of cities")) {
                victorious = true;
                break;
            }
            String letter = cityGame.getLetter(temp);
            List<String> possibleMoves = cityGame.possibleMoves(letter);
            String nextMove = cityGame.nextMove(possibleMoves);
            sendMessage(nextMove);
            if (nextMove.contains("out of cities")) break;
        }
        if (victorious) {
            sendMessage("I am victorious!");
            readMessage();
        } else {
            readMessage();
            sendMessage("gg");
        }
    }

    public void sendMessage(String message) {
        System.out.println("Player#2: " + message);
        out.println(message);
    }

    public String readMessage() {
        String receivedMessage = "";
        try {
            receivedMessage = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return receivedMessage;
    }

    public void stop() {
        if (in != null && out != null && clientSocket != null) {
            try {
                in.close();
                out.close();
                clientSocket.close();
                System.out.println("Player#2: stopped");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
