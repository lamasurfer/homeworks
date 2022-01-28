package unit_1.homework1_5;

import java.util.Scanner;

class LongCalcNew {
    public static void main(String[] args) {
        System.out.println("Данная программа позволяет :"
                + "\n  отбросить дробную часть чисел (drop_dot);"
                + "\n  сравнить числа (compare);"
                + "\n  округлить числа (round)");

        Scanner sc1 = new Scanner(System.in);

        while (true) {

            System.out.println("\nВведите первое число: ");
            String input = sc1.next().trim();

            if ("end".equals(input)) {
                System.out.println("Завершение работы.");
                break;
            } // выход из цикла

            double value1 = Double.parseDouble(input);
            System.out.println("Введите второе число: ");
            double value2 = Double.parseDouble(sc1.next().trim());

            System.out.println("Выберите операцию: ");
            Operation operation = Operation.valueOf(sc1.next().trim());

            calc(value1, value2, operation);
        }
    }

    static void calc(double value1, double value2, Operation operation) {
        switch (operation) {
            case drop_dot:
                System.out.printf("Число 1 без дробной части = %s; %n", (long) value1);
                System.out.printf("Число 2 без дробной части = %s. %n", (long) value2);
                break;
            case compare:
                if (Math.abs(value1 - value2) < 0.000000001) {
                    System.out.println("Числа равны.");
                } else {
                    System.out.println("Числа не равны.");
                }
                break;
            case round:
                System.out.printf("Округленное число 1 = %s; %n", Math.round(value1));
                System.out.printf("Округленное число 2 = %s. %n", Math.round(value2));
                break;
        }
    }
}
