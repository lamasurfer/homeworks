package org.example.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;


    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server: started");
            clientSocket = serverSocket.accept();
            System.out.println("Server: new connection accepted");
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }

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

    public void sendMessage(String message) {
        out.println(message);
    }

    public void sendTaskMessage(String message) {
        String sentMessage = String.format("Hi %s, your port is %d!", message, clientSocket.getPort());
        out.println(sentMessage);
    }

    public void stop() {
        if (in != null && out != null && clientSocket != null && serverSocket != null) {
            try {
                in.close();
                out.close();
                clientSocket.close();
                serverSocket.close();
                System.out.println("Server: stopped");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
