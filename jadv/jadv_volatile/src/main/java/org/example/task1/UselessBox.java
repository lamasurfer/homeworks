package org.example.task1;

public class UselessBox {

    private volatile boolean off = true;

    public boolean isOff() {
        return off;
    }

    public void switchOn() {
        System.out.println("Switched on!");
        off = false;
    }

    public void switchOff() {
        System.out.println("Switched off!");
        off = true;
    }
}
