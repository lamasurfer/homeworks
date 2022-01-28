package unit_3.homework3_2.task321;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);

        Player player = new Player();

        System.out.format("У тебя %d слотов с оружием,"
                        + " введи номер, чтобы выстрелить,"
                        + " -1 чтобы выйти.%n",
                player.getSlotsCount());
        player.getWeaponsList();

        int slot;
        int counter = 0;

        while (true) {
            try {
                slot = sc1.nextInt();

                if (slot == -1) {
                    System.out.println("Игра окончена! Всего выстрелов " + counter);
                    break;
                }
                player.shotWithWeapon(slot);
                counter++;
            } catch (InputMismatchException exc) {
                System.out.println("Введи целое число от 0 до " + player.getSlotsCount());
                sc1.nextLine();
            }
        }
    }
}
