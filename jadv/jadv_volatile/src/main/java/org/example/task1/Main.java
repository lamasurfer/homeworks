package org.example.task1;

public class Main {
    public static void main(String[] args) {

        final UselessBox uselessBox = new UselessBox();

        Thread boxUser = new Thread(new BoxUser(uselessBox));
        Thread boxSwitch = new Thread(new BoxSwitch(uselessBox));

        boxUser.start();
        boxSwitch.start();

        try {
            boxUser.join();
            boxSwitch.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
