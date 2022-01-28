package unit_1.homework1_4;

import java.util.Scanner;

class Decoder {

    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);
        String result = "";

        while (true) { // бесконечный цикл

            System.out.println("Введите ASCII код (end для вывода результата):");
            String input = sc1.nextLine();

            if ("end".equals(input)) {
                System.out.println("Результат: " + result);
                break; // выход и вывод результата
            }

            //char c = convert(input);
            //result += c;
            result += convert(input); // накопление символов

        }
    }

    // метод расшифровки ASCII кода
    static char convert(String a) {
        return (char) Integer.parseInt(a, 8);
    }
}
