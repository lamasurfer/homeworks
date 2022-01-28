package org.example.task1;

import org.example.task1.javacore_osi.Server;

import java.math.BigInteger;

public class FibonacciServer extends Server {

    public FibonacciServer(int port) {
        super(port);
    }

    @Override
    public void start() {
        super.start();
        while (true) {
            String received = readMessage();
            if ("end".equals(received)) {
                break;
            }
            sendMessage(received);
        }
        super.stop();
    }

    @Override
    public void sendMessage(String message) {
        message = getFibonacciString(message);
        super.sendMessage(message);
    }

    private String getFibonacciString(String input) {
        try {
            int ordinal = Integer.parseInt(input);
            return getFibonacci(ordinal).toString();
        } catch (NumberFormatException e) {
            return "error";
        }
    }

    private BigInteger getFibonacci(int n) {
        if (n == 0) {
            return BigInteger.ZERO;
        }
        if (n == 1) {
            return BigInteger.ONE;
        }
        BigInteger first = BigInteger.ZERO;
        BigInteger second = BigInteger.ONE;
        BigInteger next = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            next = first.add(second);
            first = second;
            second = next;
        }
        return next;
    }
}
