package org.example.task1;

public class BoxSwitch implements Runnable {

    private final UselessBox uselessBox;

    public BoxSwitch(UselessBox uselessBox) {
        this.uselessBox = uselessBox;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (!uselessBox.isOff()) {
                uselessBox.switchOff();
            }
        }
    }
}
