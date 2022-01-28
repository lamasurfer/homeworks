package unit_1.homework1_3;

import java.util.Scanner;

class CheckYear {
    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);

        System.out.println("Данная программа рассчитывает количество дней в году.");

        while (true) { // бесконечный цикл для повтора программы

            System.out.println("Введите год в формате \"yyyy\" или \"q\" для выхода и нажмите enter:");
            String input = sc1.nextLine();

            if ("q".equals(input) || "й".equals(input)) {
                System.out.println("Завершение программы");
                break;
            } // выход

            int year = Integer.parseInt(input); // преобразование ввода в число

            // проверка года
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                System.out.println("Количество дней: 366, високосный год.");
            } else {
                System.out.println("Количество дней: 365.");
            }
        }
    }
}
