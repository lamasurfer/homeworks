package unit_3.homework3_1.task311;

public class Book {
    private String title;
    private Status status;

    public Book(String title) {
        this.title = title;
        status = Status.AVAILABLE;
    }

    public Book(String title, Status status) {
        this.title = title;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Книга " + title + ", статус " + status + ".";
    }
}

