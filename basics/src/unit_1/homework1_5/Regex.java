package unit_1.homework1_5;

import java.util.Scanner;

class Regex {
    public static void main(String[] args) {

        System.out.println("Данная программа удаляет лишние пробелы в тексте."
                + "\nВведите любой текст с большим количеством пробелов : ");
        Scanner sc1 = new Scanner(System.in);
        String input = sc1.nextLine();

        System.out.println(extraTrim(input));
    }

    static String extraTrim(String input) {
        String result = input.trim().replaceAll("\\s(\\p{Punct})", "$1").replaceAll("\\s+", " ");
        return result;
    }
}
