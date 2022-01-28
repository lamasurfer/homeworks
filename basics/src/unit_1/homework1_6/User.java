package unit_1.homework1_6;

public class User {

    public static int totalOnline = 0; // пользователей онлайн

    public String email;
    public String name;
    public String surname;
    public Book[] books;

    public User(String email, String name, String surname, Book[] books) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.books = books;
        totalOnline++; // увеличивается с каждым новым
    }

    public String toString() {
        return "\nПользователь " + name + " " + surname + ", email: " + email;
    }

    public void full(User User) {
        System.out.println(User);
        for (Book book : User.books) {
            System.out.printf("%n«%s»", book.title);
            for (Author author : book.authors) {
                System.out.printf(" %s %s", author.name, author.surname);
            }
        }
    }

}
