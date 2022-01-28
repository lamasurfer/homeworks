package org.example.task1.javacore_osi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private final String ip;
    private final int port;
    private Socket clientSocket;
    private PrintWriter writer;
    private BufferedReader reader;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void start() {
        try {
            clientSocket = new Socket(ip, port);
            System.out.println("Client: started");
            writer = new PrintWriter(clientSocket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sendMessage(String message) {
        try {
            writer.println(message);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public String readMessage() {
        String error = "Error!";
        try {
            return reader.readLine();
        } catch (IOException | NullPointerException e) {
            return error;
        }
    }

    public void stop() {
        if (reader != null && writer != null && clientSocket != null) {
            try {
                reader.close();
                writer.close();
                clientSocket.close();
                System.out.println("Client: stopped");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
