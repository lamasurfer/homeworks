package unit_3.homework3_3.task331.interfaces;

import unit_3.homework3_3.task331.Book;

public interface Administrator {

    void overdueNotification(Reader reader, Book book);

    void giveBook(Book book, Reader reader);

}

