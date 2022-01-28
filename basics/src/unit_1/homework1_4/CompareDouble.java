package unit_1.homework1_4;

import java.util.Scanner;

class CompareDouble {
    public static void main(String[] args) {
        System.out.println("Данная программа позволяет :\n  отбросить дробную часть чисел (drop_dot);"
                + "\n  сравнить числа (compare); \n  округлить числа (round)");

        Scanner sc1 = new Scanner(System.in);

        while (true) {

            System.out.println("\nВыберите операцию drop_dot, compare или "
                    + "round и нажмите enter (end для выхода).");
            String opertion = sc1.nextLine();

            if ("end".equals(opertion)) {
                System.out.println("Завершение работы.");
                break;
            } // выход из цикла

            System.out.println("Введите первое число: ");
            String input = sc1.nextLine();
            double value1 = Double.parseDouble(input);
            System.out.println("Введите второе число: ");
            double value2 = sc1.nextDouble();
            sc1.nextLine();

            switch (opertion) {
                case "drop_dot": //отброс дробной
                    dropDot(value1, value2);
                    break;
                case "compare": //сравнение
                    compare(value1, value2);
                    break;
                case "round": // округление
                    round(value1, value2);
                    break;
            }
        }
    }

    static void dropDot(double value1, double value2) {
        System.out.printf("Число 1 без дробной части = %s; %n", (long) value1);
        System.out.printf("Число 2 без дробной части = %s. %n", (long) value2);
    }

    static void compare(double value1, double value2) {
        if (Math.abs(value1 - value2) < 0.000000001) {
            System.out.println("Числа равны.");
        } else {
            System.out.println("Числа не равны.");
        }
    }

    static void round(double value1, double value2) {
        System.out.printf("Округленное число 1 = %s; %n", Math.round(value1));
        System.out.printf("Округленное число 2 = %s. %n", Math.round(value2));
    }

}
