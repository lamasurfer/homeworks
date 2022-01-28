package org.example.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            System.out.println("Client: started");
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg) {
        out.println(msg);
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
                System.out.println("Client: stopped");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
