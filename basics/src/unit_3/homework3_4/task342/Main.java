package unit_3.homework3_4.task342;

public class Main {
    public static void main(String[] args) {

        for (Event event : getMovies()) {
            validEvent(event);
        }
        for (Event event : getTheatres()) {
            validEvent(event);
        }
        System.out.println("Все события корректны.");
    }

    public static Movie[] getMovies() {
        return new Movie[]{
                new Movie("Начало", 2010, 16),
                new Movie("Доктор Ноу", 1962, 16),
                //new Movie("Голдфингер", 0, 16),
                new Movie("Король Лев", 1994, 0), // Integer age
        };
    }

    public static Theatre[] getTheatres() {
        return new Theatre[]{
                new Theatre("День радио", 2001, 16),
                new Theatre("Анна Каренина", 2017, 16),
                //new Theatre("Анна Каренина", 2017, null),
                //new Theatre(),
        };
    }

    public static void validEvent(Event event) {
        if (event.getTitle() == null || event.getReleaseYear() == 0 || event.getAge() == null) {
            throw new RuntimeException("Looks like there's null in..." + event.toString());
        }
    }
}