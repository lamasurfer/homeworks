package unit_3.homework3_4.training34;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String url = scanner.nextLine();
            UrlUtils.validate(url);
            System.out.print("Введенный url корректен");
        } catch (Exception e) {
            System.out.print("Введенный url некорректен");
        }
    }
}