package org.example.task2;

public class Deal implements Comparable<Deal>{

    private final int length;
    private final int width;
    private final int priceOfMeter;
    private final long totalPrice;

    public Deal(int length, int width, int priceOfMeter) {
        this.length = length;
        this.width = width;
        this.priceOfMeter = priceOfMeter;
        this.totalPrice = (long) length * width * priceOfMeter;
    }

    public int getPriceOfMeter() {
        return priceOfMeter;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    @Override
    public int compareTo(Deal o) {
        return Long.compare(this.getTotalPrice(), o.getTotalPrice());
    }


    @Override
    public String toString() {
        return String.format("Участок: длина %-3s м, ширина %-3s м, цена за м2 - %-4s руб., всего %-5s руб.",
                length, width, priceOfMeter, totalPrice);
    }
}
