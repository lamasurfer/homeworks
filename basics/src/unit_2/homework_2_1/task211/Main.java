package unit_2.homework_2_1.task211;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] products = new String[]{"Хлеб", "Яблоки", "Молоко"};
        int[] prices = new int[]{100, 200, 300};

        System.out.println("Список возможных товаров для покупки: ");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%n%s. %s \t %s руб.", i + 1, products[i], prices[i]);
        }

        Scanner sc1 = new Scanner(System.in);

        int counter = 0; // счетчик для массивов хранения
        int productNumber = 0;
        int productCount = 0;
        int totalSum = 0; // итого
        int[] numChoice = new int[10]; // массив хранения выбора продуктов
        int[] qtyChoice = new int[10]; // массив хранения выбора кол-ва продуктов

        while (true) {

            System.out.println("\nВведите номер продукта и его количество через пробел или введите `end` для выхода");
            String input = sc1.next();

            if ("end".equals(input) || counter == 10) {
                System.out.println("Наименование\t Кол-во\t Цена/за ед. Общая стоимость");
                for (int i = 0; i < counter; i++) {
                    System.out.printf("%n%s \t\t\t %s\t\t %s \t\t %s ", products[numChoice[i]], qtyChoice[i],
                            prices[numChoice[i]], qtyChoice[i] * prices[numChoice[i]]);
                }
                System.out.printf("%n\t\t\t\t\t\t Итого : \t %s", totalSum);
                break;
            }

            try {
                productNumber = Integer.parseInt(input);
                productCount = sc1.nextInt();

                numChoice[counter] = productNumber - 1; // сохранение номера продукта
                qtyChoice[counter] = productCount; // сохранение кол-ва продукта
                totalSum += qtyChoice[counter] * prices[numChoice[counter]]; // накопление итого
                counter++;

            } catch (final InputMismatchException | NumberFormatException | ArrayIndexOutOfBoundsException ex) {
                System.out.println("Ошибка ввода. Введите номер продукта и его количество через пробел.");
                sc1.nextLine();
            }
        }

//        System.out.println("Наименование\t Кол-во\t Цена/за ед. Общая стоимость");
//        for (int i = 0; i < counter; i++) {
//            System.out.printf("%n%s \t\t\t %s\t\t %s \t\t %s ", products[numChoice[i]], qtyChoice[i],
//                    prices[numChoice[i]], qtyChoice[i] * prices[numChoice[i]]);
//        }
//        System.out.printf("%n\t\t\t\t\t\t Итого : \t %s", totalSum);

    }
}
