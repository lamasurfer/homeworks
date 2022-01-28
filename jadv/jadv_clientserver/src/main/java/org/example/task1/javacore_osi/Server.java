package org.example.task1.javacore_osi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final int port;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter writer;
    private BufferedReader reader;

    public Server(int port) {
        this.port = port;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server: started");
            clientSocket = serverSocket.accept();
            System.out.println("Server: new connection accepted");
            writer = new PrintWriter(clientSocket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        } catch (IOException e) {
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

    public void sendMessage(String message) {
        try {
            writer.println(message);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void stop() {
        if (reader != null && writer != null && clientSocket != null && serverSocket != null) {
            try {
                reader.close();
                writer.close();
                clientSocket.close();
                serverSocket.close();
                System.out.println("Server: stopped");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

