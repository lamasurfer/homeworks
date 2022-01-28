package unit_3.homework3_4.task342;

public class Theatre extends Event {

    public Theatre() {
        super();
    }

    public Theatre(String title, int releaseYear, Integer age) {
        super(title, releaseYear, age);
    }

    @Override
    public String toString() {
        return "Спектакль " + super.toString();
    }
}