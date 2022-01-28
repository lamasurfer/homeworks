package unit_1.homework1_6;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Author author1 = new Author(); // через конструктор по умолчанию
        author1.name = "Карл";
        author1.surname = "Маркс";
        author1.birthday = LocalDate.parse("1818-05-05");
        author1.origin = "Германия";

        Author author2 = new Author(
                "Фридрих",
                "Энгельс",
                LocalDate.parse("1820-11-28"),
                "Германия"); // через созданный конструктор

        Book book1 = new Book(
                "Капитал",
                1867,
                1852,
                new Author[]{author1},
                "Главный труд немецкого экономиста Карла Маркса по политической экономии, содержащий " +
                        "критический анализ капитализма.");

        Book book2 = new Book(
                "Происхождение семьи, частной собственности и государства",
                1884,
                602,
                new Author[]{author2},
                "Произведение немецкого мыслителя Фридриха Энгельса, посвящённое основным проблемам  " +
                        "первоначальнойистории, эволюции семейно-брачных отношений, анализа процессов разложения " +
                        "родового общества, становления частной собственности, общественных классов и государства.");

        Book book3 = new Book(
                "Манифест Коммунистической партии",
                1848,
                130,
                new Author[]{author1, author2}); // через короткий конструктор

        User user1 = new User(
                "vilenin@mail.ru",
                "Владимир Ильич",
                "Ленин",
                new Book[]{book1, book2, book3}
        );

        User user2 = new User(
                "leontrotsky@mail.ru",
                "Лев Давидович",
                "Троцкий",
                new Book[]{book1, book3}
        );

        // 1.6.1
        System.out.println("\n" + book1.toString());

        // с описанием по умолчанию
        System.out.println("\n" + book3.fullDescription());

        // 1.6.2
        System.out.println("\nАвтор(ы) книги " + "«" + book3.title + "»");
        for (Author author : book3.authors) {
            System.out.printf("%s %s%n", author.name, author.surname);
        }

        System.out.println("\n" + author1.toString());
        // 1.6.2
        System.out.println("\nПользователь " + user1.name + " " + user1.surname + " читает:");
        for (Book book : user1.books) {
            System.out.printf("%n«%s»", book.title);
            for (Author author : book.authors) {
                System.out.printf(" %s %s", author.name, author.surname);
            }
        }
        System.out.println("\n" + user2.toString());

        // 1.6.3
        System.out.println("\nПользователей онлайн: " + User.totalOnline);

        user1.full(user1);

    }
}
