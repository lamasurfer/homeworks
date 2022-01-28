package unit_4.homework4_2.task422;


import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            try {
                System.out.println("\nВведите математическую формулу:"
                        + "\n(допустимые символы: цифры от 0 до 9, математические операции +, -, *, /)");
                input = scanner.nextLine().trim();
                checkInput(input);
                checkExpression(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nПринятые к обработке символы " + Arrays.toString(input.toCharArray()));
        String[] results = formatInput(input);
        System.out.println("После форматирования " + Arrays.toString(results));

        Stack<String> signs = new Stack<>();
        Queue<Integer> numbers = new ArrayDeque<>();

        for (String s : results) {
            if (s.matches("[+\\-*/]+")) {
                signs.add(s);
            } else {
                numbers.add(Integer.parseInt(s));
            }
        }

        System.out.println("\nРезльтат: ");
        while (!numbers.isEmpty()) {
            System.out.printf("%s ", numbers.poll());
        }
        while (!signs.isEmpty()) {
            System.out.printf("%s ", signs.pop());
        }
    }

    public static void checkInput(String input) {
        if (!input.matches("([\\d*\\-/+\\s]+)")) {
            throw new IllegalArgumentException("Введены недопустимые символы!");
        } else if (input.matches("[+\\-*/]+")) {
            throw new IllegalArgumentException("Слишком мало символов!");
        }
    }

    public static void checkExpression(String input) {
        if (input.matches("(\\d+\\s+\\d+)|(.+\\d+\\s+\\d+.+)|(.+\\d+\\s+\\d+)|(\\d+\\s+\\d+.+)")
                || input.matches("(\\D+\\s+\\D+)|(.+\\D+\\s+\\D+.+)|(.+\\D+\\s+\\D+)|(\\D+\\D+\\D+.+)")) {
            System.out.println("\nСкорее всего введенная формула некорректна."
                    + "\nПрограмма попробует ее отформатировать, но вряд ли вы получите желаемый результат.");
        }
    }

    public static String[] formatInput(String input) {
        String result = input.replaceAll("(^\\D+)(.+)(\\D+$)", "$2") // + 1 + 1 -> 1 + 1
                //.replaceAll("(\\D+$)", "") // 1 + 1 + -> 1 + 1
                .replaceAll("([+\\-*/])([+\\-*/\\s]+)", "$1 ") // 1 ++ +-+++ 1 -> 1 + 1
                .replaceAll("([\\d]+)\\s+([\\d]+)\\s*", "$1$2") // 2 + 2 22 1 -> 2 + 2221
                .replaceAll("([\\d]+)(\\W*)", "$1 $2 "); // 2+2 -> 2 + 2
        return result.split("\\s+");
    }
}
