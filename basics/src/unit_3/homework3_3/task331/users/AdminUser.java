package unit_3.homework3_3.task331.users;

import unit_3.homework3_3.task331.Book;
import unit_3.homework3_3.task331.interfaces.Administrator;
import unit_3.homework3_3.task331.interfaces.Librarian;
import unit_3.homework3_3.task331.interfaces.Reader;
import unit_3.homework3_3.task331.interfaces.Supplier;


public class AdminUser extends User implements Administrator, Librarian {

    @Override
    public void overdueNotification(Reader reader, Book book) {
        System.out.println("Верните книгу " + book.getTitle() + "!");
    }

    @Override
    public void giveBook(Book book, Reader reader) {
        System.out.println("Выдана книга " + book.getTitle());
    }

    @Override
    public void buyBook(Book book, Supplier supplier) {
        System.out.println("Куплена книга " + book.getTitle());
    }
}
