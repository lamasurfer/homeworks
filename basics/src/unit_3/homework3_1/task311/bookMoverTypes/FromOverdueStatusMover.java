package unit_3.homework3_1.task311.bookMoverTypes;

import unit_3.homework3_1.task311.Book;
import unit_3.homework3_1.task311.BookMover;
import unit_3.homework3_1.task311.Status;


public class FromOverdueStatusMover extends BookMover {

    public FromOverdueStatusMover() {
        super(Status.OVERDUE);
    }

    @Override
    public String getBookMoverName() {
        return "Метод перевода из статуса " + getBookMoverStatus() + ".";
    }

    @Override
    public Status getBookMoverStatus() {
        return Status.OVERDUE;
    }

    @Override
    protected void moveToStatus(Book book, Status requestedStatus) {
        if (book.getStatus().equals(getBookMoverStatus())) {
            switch (requestedStatus) {
                case ARCHIVED:
                case AVAILABLE:
                    book.setStatus(requestedStatus);
                    System.out.println("Статус книги " + book.getTitle() + " успешно изменен с " + getBookMoverStatus()
                            + " на " + book.getStatus() + ".");
                    break;
                case BORROWED:
                    System.out.println("Перевод книги " + book.getTitle() + " из статуса " + book.getStatus()
                            + " в статус " + requestedStatus + " невозможен.");
                    break;
                case OVERDUE:
                    System.out.println("Статус книги " + book.getTitle() + " уже " + getBookMoverStatus() + ".");
                    break;
            }
        } else {
            System.out.println("Статус книги " + book.getTitle() + " не соответствует выбранному методу - "
                    + getBookMoverName() + " Изменение статуса невозможно.");
        }
    }
}
