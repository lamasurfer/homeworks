package unit_3.homework3_1.task311;

public class BookMover {
    protected Status status;

    public BookMover(Status status) {
        this.status = status;
    }

    protected void moveToStatus(Book book, Status requestedStatus) {
        System.out.println("Moving status...");
    }

    public Status getBookMoverStatus() {
        return status;
    }

    public String getBookMoverName() {
        return "Метод изменения статуса";
    }

    @Override
    public String toString() {
        return "BookMover status " + status;
    }
}



