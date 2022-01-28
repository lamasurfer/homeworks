package unit_3.homework3_4.task342;

public class Movie extends Event {

    public Movie() {
        super();
    }

    public Movie(String title, int releaseYear, Integer age) {
        super(title, releaseYear, age);
    }

    @Override
    public String toString() {
        return "Фильм " + super.toString();
    }
}
