package unit_4.homework4_2.task421.old;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Deque<Integer> floors = new ArrayDeque<>();

        final int STARTING_FLOOR = 1;
        final int STANDING_TIME = 10;
        final int MOVING_TIME = 5;
        int totalTime = 0;

        floors.add(STARTING_FLOOR); // начинаем с первого, STANDING_TIME на нем не учитываем

        System.out.print("Лифт на 1-м этаже. В здании 26 этажей начиная с нулевого.");

        while (true) {

            System.out.println("\nОжидаю ввода этажа: (для завершения введите 0)");

            try {
                int floor = scanner.nextInt();

                if (floor < 0 || floor > 25) {
                    System.out.println("\nТакого этажа нет!");
                } else if (floors.getLast() == floor) {
                    System.out.println("\nМы уже на этом этаже!");
                } else {
                    totalTime += MOVING_TIME * Math.abs(floor - floors.getLast());
                    if (floor != 0) totalTime += STANDING_TIME;
                    floors.add(floor);
                }

                if (floor == 0) {
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("\nНужно ввести номер этажа!");
                scanner.nextLine();
            }
        }

        System.out.println("\nВремя затраченное лифтом на маршрут: " + totalTime + " с.");

        System.out.printf("этаж %s", floors.poll());
        floors.forEach(floor -> System.out.printf(" -> этаж %s", floors.poll()));

    }
}