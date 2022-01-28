package unit_1.homework1_6;

public class Book {

    public String title;
    public int year;
    public int pages;
    public Author[] authors;
    public String description;

    public Book(String title, int year, int pages, Author[] authors, String description) {
        this.title = title;
        this.year = year;
        this.pages = pages;
        this.authors = authors;
        this.description = description;
    }

    public Book(String title, int year, int pages, Author[] authors) {
        this(title, year, pages, authors, "Описание появится позже.");
    } // конструктор со значинием по умолчанию

    public String toString() {
        return "Книга " + "«" + title + "»";
    }

    public String fullDescription() {
        return "Книга " + "«" + title + "»" + " впервые опубликована в " + year + " году. Кол-во страниц: "
                + pages + " шт. " + description;
    }

    //public String full(User) { TODO
    //for(Book book: user.books) {
    //    System.out.printf("%n«%s»" , book.title);
    //    for (Author author: book.authors) {
    //      System.out.printf(" %s %s" , author.name, author.surname);
    //    }
    //}
}
