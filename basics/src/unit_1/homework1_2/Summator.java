package unit_1.homework1_2;

import java.util.Scanner;

class Summator {

    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);

        System.out.println("Добрый день! \n" + "Данная программа вычисляет сумму трех целых чисел. \n" + "Введите первое целое число и нажмите enter:");

        int value1 = sc1.nextInt();

        System.out.println("Введите второе целое число:");

        int value2 = sc1.nextInt();

        System.out.println("Введите третье целое число:");

        int value3 = sc1.nextInt();

        int result = sum(value1, value2, value3);

        System.out.println("Вы ввели числа: " + value1 + ", " + value2 + ", " + value3 + "\nСумма: " + result);

    }

    static int sum(int value1, int value2, int value3) {
        return value1 + value2 + value3;

    }
}
