package unit_4.homework4_2;

import java.util.Scanner;

public class Regex422Test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите математическую формулу:");
        String input = scanner.nextLine().trim();

//        String result = input.replaceAll("([\\d]+)(\\W*)", "$1 $2 ")
//                .replaceAll("([+\\-*/]\\s+)([+\\-*/]+)", "$1") // + - на +
//                .replaceAll("([+\\-*/])([+\\-*/]+)", "$1") // +- на +
//                .replaceAll("([\\d]+)\\s+([\\d]+)", "$1$2") // 1 1 на 11
//                .replaceAll("([\\d]+)(\\s+)", "$1")
//                .replaceAll("([\\d]+)(\\W*)", "$1 $2 ");

        String string1 = input
                .replaceAll("(^\\D+)", "")
                .replaceAll("(\\D+$)", "")
                .replaceAll("([+\\-*/])([+\\-*/\\s]+)", "$1 ")
                .replaceAll("([\\d]+)\\s+([\\d]+)\\s", "$1$2")
                .replaceAll("([\\d]+)(\\W*)", "$1 $2 ");
        System.out.println("a1   " + string1);


    }
}
