package unit_3.homework3_3.task331;

import unit_3.homework3_3.task331.users.*;

public class Main {
    public static void main(String[] args) {

        Book book = new Book("The Lord of the Rings");

        AdminUser admin = new AdminUser();
        ReaderUser reader = new ReaderUser();
        SupplierUser supplier = new SupplierUser();
        LibrarianUser librarian = new LibrarianUser();

        System.out.println();
        reader.borrowBook(book, admin);
        reader.read(book);
        reader.returnBook(book, admin);

        System.out.println();
        admin.buyBook(book, supplier);
        admin.overdueNotification(reader, book);
        admin.giveBook(book, reader);

        System.out.println();
        supplier.supplyBook(book, librarian);
        supplier.borrowBook(book, admin);
        supplier.read(book);
        supplier.returnBook(book, admin);

        System.out.println();
        librarian.buyBook(book, supplier);

        System.out.println();
        User uberUser = new AdminUser();
        ((AdminUser) uberUser).buyBook(book, supplier);
        ((AdminUser) uberUser).overdueNotification(reader, book);
        ((AdminUser) uberUser).giveBook(book, reader);

    }
}

