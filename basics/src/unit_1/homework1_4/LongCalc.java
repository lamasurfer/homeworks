package unit_1.homework1_4;

import java.util.Scanner;

class LongCalc {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        // цикл
        while (true) {
            System.out.println("Введите первое число (для выхода введите    end)");
            String input = sc1.next();

            // выход
            if ("end".equals(input)) {
                break;
            }
            // ввод чисел
            long value1 = Long.parseLong(input);
            System.out.println("Введите второе число");
            long value2 = sc1.nextLong();

            // выбор операции
            System.out.println("Выберите операцию abs, div, div_round, pow");
            String oper = sc1.next();
            // вычисления
            switch (oper) {
                case "abs": // модуль
                    System.out.printf("value1 abs = %s %n", Math.abs(value1));
                    System.out.printf("value2 abs = %s %n", Math.abs(value2));
                    break;
                case "div": // деление
                    System.out.printf("div = %s %n", (double) value1 / value2);
                    break;
                case "div_round": // деление с округлением
                    System.out.printf("div_round = %s %n", Math.round((double) value1 / value2));
                    break;
                case "pow": //
                    System.out.printf("pow = %s %n", Math.pow(value1, value2));
                    break;
            }
        }
        System.out.println("-----------------------------------------------");
    }
}
