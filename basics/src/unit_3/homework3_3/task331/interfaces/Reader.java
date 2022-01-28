package unit_3.homework3_3.task331.interfaces;

import unit_3.homework3_3.task331.Book;

public interface Reader {

    void borrowBook(Book book, Administrator admin);

    void read(Book book);

    void returnBook(Book book, Administrator admin);

}
