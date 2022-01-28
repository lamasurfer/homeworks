package unit_4.homework4_2.task421;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Lift lift = new Lift();
        Passenger passenger = new Passenger(lift);

        System.out.println("\nОжидаю ввода этажа: (для завершения введите 0)");
        passenger.useLift(scanner.nextInt());


//        System.out.print("Лифт на 1-м этаже. В здании 26 этажей начиная с нулевого.");
//
//        while (true) {
//
//            System.out.println("\nОжидаю ввода этажа: (для завершения введите 0)");
//
//            try {
//                int floor = scanner.nextInt();
//
//                if (floor < 0 || floor > 25) {
//                    System.out.println("\nТакого этажа нет!");
//                } else if (lift.getLastStop() == floor) {
//                    System.out.println("\nМы уже на этом этаже!");
//                } else {
//                      lift.addNewStop(floor);
//                }
//
//                if (floor == 0) {
//                    break;
//                }
//
//            } catch (InputMismatchException e) {
//                System.out.println("\nНужно ввести номер этажа!");
//                scanner.nextLine();
//            }
//        }

        System.out.println("\nВремя затраченное лифтом на маршрут: " + lift.getTotalTime() + " с.");

        lift.showStops();
    }
}
