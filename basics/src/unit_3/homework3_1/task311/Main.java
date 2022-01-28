package unit_3.homework3_1.task311;

import unit_3.homework3_1.task311.bookMoverTypes.FromArchivedStatusMover;
import unit_3.homework3_1.task311.bookMoverTypes.FromAvailableStatusMover;
import unit_3.homework3_1.task311.bookMoverTypes.FromBorrowedStatusMover;
import unit_3.homework3_1.task311.bookMoverTypes.FromOverdueStatusMover;

public class Main {
    public static void main(String[] args) {

        Book lotr = new Book("The Fellowship of the Ring");

        Book lotr2 = new Book("The Two Towers", Status.ARCHIVED);

        Book lotr3 = new Book("The Return of the King", Status.BORROWED);

        Book taba = new Book("The Hobbit", Status.OVERDUE);

        Book silmarillion = new Book("The Silmarillion", Status.BORROWED);


        System.out.println();
        System.out.println(lotr.toString());
        BookMover fromAvailableStatusMover = new FromAvailableStatusMover();
        fromAvailableStatusMover.moveToStatus(lotr, Status.AVAILABLE);
        fromAvailableStatusMover.moveToStatus(lotr, Status.OVERDUE);
        fromAvailableStatusMover.moveToStatus(lotr, Status.BORROWED);
        fromAvailableStatusMover.moveToStatus(lotr, Status.BORROWED);
        System.out.println(lotr.toString());

        System.out.println();
        System.out.println(lotr2.toString());
        BookMover fromArchivedStatusMover = new FromArchivedStatusMover();
        fromArchivedStatusMover.moveToStatus(lotr2, Status.BORROWED);
        fromArchivedStatusMover.moveToStatus(lotr2, Status.OVERDUE);
        fromArchivedStatusMover.moveToStatus(lotr2, Status.AVAILABLE);
        fromArchivedStatusMover.moveToStatus(lotr2, Status.AVAILABLE);
        System.out.println(lotr2.toString());


        System.out.println();
        System.out.println(lotr3.toString());
        BookMover fromBorrowedStatusMover = new FromBorrowedStatusMover();
        fromBorrowedStatusMover.moveToStatus(lotr3, Status.AVAILABLE);

        System.out.println(lotr.toString());
        fromBorrowedStatusMover.moveToStatus(lotr, Status.ARCHIVED);

        System.out.println(silmarillion.toString());
        fromBorrowedStatusMover.moveToStatus(silmarillion, Status.OVERDUE);


        System.out.println();
        System.out.println(taba.toString());
        BookMover fromOverdueStatusMover = new FromOverdueStatusMover();
        fromOverdueStatusMover.moveToStatus(taba, Status.BORROWED);
        fromOverdueStatusMover.moveToStatus(taba, Status.OVERDUE);
        fromOverdueStatusMover.moveToStatus(taba, Status.ARCHIVED);
        fromOverdueStatusMover.moveToStatus(silmarillion, Status.AVAILABLE);
        //...
    }
}