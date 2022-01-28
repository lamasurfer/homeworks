package unit_3.homework3_3.task331.users;

import unit_3.homework3_3.task331.Book;
import unit_3.homework3_3.task331.interfaces.Administrator;
import unit_3.homework3_3.task331.interfaces.Reader;

public class ReaderUser extends User implements Reader {

    @Override
    public void borrowBook(Book book, Administrator admin) {
        System.out.println("Взята книга " + book.getTitle());
    }

    @Override
    public void read(Book book) {
        System.out.println("Читаю книгу " + book.getTitle());
    }

    @Override
    public void returnBook(Book book, Administrator admin) {
        System.out.println("Возвращена книга " + book.getTitle());
    }
}

