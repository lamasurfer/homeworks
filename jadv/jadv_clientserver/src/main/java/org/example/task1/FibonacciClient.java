package org.example.task1;

import org.example.task1.javacore_osi.Client;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FibonacciClient extends Client {

    private final int MAX_NUMBER = 1_000_000;
    private final Scanner scanner;

    public FibonacciClient(String ip, int port, Scanner scanner) {
        super(ip, port);
        this.scanner = scanner;
    }

    @Override
    public void start() {
        super.start();
        while (true) {
            System.out.println(">> Введите порядковый номер числа Фибоначчи (от 0 до " + MAX_NUMBER + ") " +
                    "и нажмите enter (или введите end для выхода):");
            String message = scanner.nextLine();
            if ("end".equals(message)) {
                sendMessage(message);
                break;
            } else if (checkInput(message)) {
                sendMessage(message);
                String received = readMessage();
                System.out.println(received);
            } else {
                System.out.println(">> Ошибка ввода");
            }
        }
        super.stop();
    }

    private boolean checkInput(String input) {
        if (input == null || input.isBlank()) {
            return false;
        }
        Pattern pattern = Pattern.compile("\\D");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return false;
        }
        int parsed = Integer.parseInt(input);
        return parsed >= 0 && parsed <= MAX_NUMBER;
    }
}
