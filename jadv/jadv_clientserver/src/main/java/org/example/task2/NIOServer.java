package org.example.task2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class NIOServer {

    private final InetSocketAddress inetSocketAddress;

    public NIOServer(InetSocketAddress inetSocketAddress) {
        this.inetSocketAddress = inetSocketAddress;
    }

    public void start() {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.bind(inetSocketAddress);

//            while (true) {
                System.out.println("Server: Waiting for connection...");
                SocketChannel socketChannel = serverSocketChannel.accept();
                handle(socketChannel);
//            }

        } catch (IOException e) {
            System.out.println("Connection problems!");
        }
    }

    public void handle(SocketChannel socketChannel) {
        try (socketChannel) {

            System.out.println("Server: new connection accepted");
            final ByteBuffer inputBuffer = ByteBuffer.allocate(2 << 10);
            while (socketChannel.isConnected()) {

                int bytesCount = socketChannel.read(inputBuffer);
                if (bytesCount == -1) break;

                String received = new String(inputBuffer.array(), 0, bytesCount, StandardCharsets.UTF_8);
                System.out.println("Server received " + received);
                if ("end".equals(received)) {
                    return;
                }
                inputBuffer.clear();
                String message = removeWhitespaces(received);
                socketChannel.write(ByteBuffer.wrap((message).getBytes(StandardCharsets.UTF_8)));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String removeWhitespaces(String input) {
        return input.replaceAll("\\s+", "");
    }

    public static void main(String[] args) {

        final String ip = "127.0.0.1";
        final int port = 8082;

        InetSocketAddress address = new InetSocketAddress(ip, port);
        NIOServer nioServer = new NIOServer(address);
        nioServer.start();
    }
}
