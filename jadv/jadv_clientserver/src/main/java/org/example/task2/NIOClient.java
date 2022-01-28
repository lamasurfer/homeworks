package org.example.task2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class NIOClient {

    private final InetSocketAddress socketAddress;

    public NIOClient(InetSocketAddress socketAddress) {
        this.socketAddress = socketAddress;
    }

    public void start() {
        try (SocketChannel socketChannel = SocketChannel.open();
             Scanner scanner = new Scanner(System.in)) {

            socketChannel.connect(socketAddress);


            final ByteBuffer inputBuffer = ByteBuffer.allocate(2 << 10);

            while (socketChannel.isConnected()) {

                socketChannel.configureBlocking(false);

                System.out.println(">> Введите текст с пробелами (end для выхода):");
                String message = scanner.nextLine();
                if ("end".equals(message)) {
                    socketChannel.write(ByteBuffer.wrap(message.getBytes(StandardCharsets.UTF_8)));
                    break;
                }
                socketChannel.write(ByteBuffer.wrap(message.getBytes(StandardCharsets.UTF_8)));
                Thread.sleep(2000);
                int bytesCount = socketChannel.read(inputBuffer);
                System.out.println(new String(inputBuffer.array(), 0, bytesCount, StandardCharsets.UTF_8).trim());
                inputBuffer.clear();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        final String ip = "127.0.0.1";
        final int port = 8082;

        InetSocketAddress address = new InetSocketAddress(ip, port);
        NIOClient nioClient = new NIOClient(address);
        nioClient.start();
    }
}

