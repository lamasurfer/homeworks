package org.example.task1;

public class BoxUser implements Runnable {

    private static final long DELAY = 2000;
    private static final String MESSAGE = "Wow!";

    private final UselessBox uselessBox;

    public BoxUser(UselessBox uselessBox) {
        this.uselessBox = uselessBox;
    }

    @Override
    public void run() {
        int attempts = 5;
        try {
            while (attempts > 0) {
                if (uselessBox.isOff()) {
                    Thread.sleep(DELAY);
                    uselessBox.switchOn();
                    attempts--;
                }
            }
            System.out.println(MESSAGE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
