package org.example.task2;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        List<Deal> deals = DealGenerator.generateDeals(100, generator ->
                generator.setRandomSeed(1)
                        .setSides(50, 100)
                        .setPrice(300, 10000));

        Scanner scanner = new Scanner(System.in);
        int price = processInput(scanner);
        showDeals(deals, price);

    }

    public static int processInput(Scanner scanner) {
        System.out.println("Введите цену за квадратный метр: ");
        while (true) {
            String input = scanner.nextLine();
            if (checkInput(input)) {
                return Integer.parseInt(input);
            } else {
                System.out.println("Повторите ввод");
            }
        }
    }

    public static void showDeals(List<Deal> deals, int price) {
        final Predicate<Deal> fairDeal = deal -> deal.getPriceOfMeter() < price;
        deals.stream()
                .filter(fairDeal)
                .sorted()
                .forEach(deal -> System.out.println(deal + " - хорошая сделка"));
        System.out.println();
        deals.stream()
                .filter(Predicate.not(fairDeal))
                .sorted()
                .forEach(deal -> System.out.println(deal + " - плохая сделка"));
    }

    public static boolean checkInput(String input) {
        if (input == null || input.isBlank()) {
            return false;
        }
        Pattern pattern = Pattern.compile("\\D");
        Matcher matcher = pattern.matcher(input);
        return !matcher.find();
    }
}
