package unit_4.homework4_2.task421;

public class Passenger {

    private Lift lift;

    public Passenger(Lift lift) {
        this.lift = lift;
    }

    public void useLift(int floor) {
        lift.addNewStop(floor);
    }
}
