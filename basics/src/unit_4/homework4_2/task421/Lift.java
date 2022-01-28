package unit_4.homework4_2.task421;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lift {

    static final int STARTING_FLOOR = 1;
    static final int STANDING_TIME = 10;
    static final int MOVING_TIME = 5;

    private Deque<Integer> floors = new ArrayDeque<>();
    private int totalTime;

    public Lift() {
        floors.add(STARTING_FLOOR);
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void addNewStop(int floor) {
        this.totalTime += MOVING_TIME * Math.abs(floor - floors.getLast());
        if (floor != 0) this.totalTime += STANDING_TIME;
        floors.add(floor);
    }

    public void showStops() {
        System.out.printf("этаж %s", floors.poll());
        floors.forEach(floor -> System.out.printf(" -> этаж %s", floors.poll()));
    }

    public int getLastStop() {
        return floors.getLast();
    }


}
