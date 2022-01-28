package org.example.task2;

import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static void main(String[] args) {

        final LongAdder longAdder = new LongAdder();

        Thread shop1 = new Thread(new ShopStats("Пятерочка", longAdder, 15_354, 240_000));
        Thread shop2 = new Thread(new ShopStats("Перекресток", longAdder, 852, 880_000));
        Thread shop3 = new Thread(new ShopStats("Карусель", longAdder, 91, 2_600_000));

        shop1.start();
        shop2.start();
        shop3.start();

        try {
            shop1.join();
            shop2.join();
            shop3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Общая выручка за день: %,d руб.", longAdder.sum());
    }
}

