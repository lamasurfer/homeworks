package unit_3.homework3_3.task331;

public class Book {

    private String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Книга " + title;
    }

    public String getTitle() {
        return title;
    }
}
