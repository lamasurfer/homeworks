package unit_3.homework3_4.task342;

public abstract class Event {
    private String title;
    private int releaseYear;
    private Integer age;

    public Event() {
    }

    public Event(String title, int releaseYear, Integer age) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return title + ", дата премьеры " + releaseYear + ", возрастной рейтинг " + age + "+.";
    }
}