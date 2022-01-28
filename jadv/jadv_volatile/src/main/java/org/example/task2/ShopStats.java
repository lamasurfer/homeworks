package org.example.task2;

import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class ShopStats implements Runnable {

    private final String name;
    private final LongAdder longAdder;
    private final int totalShops;
    private final int averageRevenue;

    public ShopStats(String name, LongAdder longAdder, int totalShops, int averageRevenue) {
        this.name = name;
        this.longAdder = longAdder;
        this.totalShops = totalShops;
        this.averageRevenue = averageRevenue;
    }

    @Override
    public void run() {
        long revenue = 0;
        int[] stats = getRevenue();
        for (int stat : stats) {
            longAdder.add(stat);
            revenue += stat;
        }
        System.out.printf("%-15s %,d руб.%n", name, revenue);
    }

    private int[] getRevenue() {
        int min = (int) (averageRevenue * 0.75);
        int max = (int) (averageRevenue * 1.25);
        Random random = new Random();
        int[] result = new int[totalShops];
        for (int i = 0; i < totalShops; i++) {
            result[i] = min + random.nextInt(max - min + 1);
        }
        return result;
    }
}
