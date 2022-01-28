package unit_3.homework3_1.training31;

public class Book {

    private String title;
    private Genre[] genres;

    public Book(String title, Genre[] genres) {
        this.title = title;
        this.genres = genres;
    }

    //for creating new Book
    public Book(String title) {
        this.title = title;
    }

    public Genre[] getGenres() {
        return genres;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return this.title;
    }

}
