package unit_3.homework3_3.task331.users;

import unit_3.homework3_3.task331.Book;
import unit_3.homework3_3.task331.interfaces.Librarian;
import unit_3.homework3_3.task331.interfaces.Supplier;

public class LibrarianUser extends User implements Librarian {

    @Override
    public void buyBook(Book book, Supplier supplier) {
        System.out.println("Куплена книга " + book.getTitle());
    }
}

