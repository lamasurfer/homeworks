package unit_4.homework4_4.task442;

import java.util.Scanner;

public class CandidatesUI {

    static Scanner scanner = new Scanner(System.in);
    Candidates candidates = new Candidates();

    public void runUserInput() {

        while (true) {
            System.out.println("Введите информацию о кандидате (для завершения введите пустую строку):"
                    + "\nФамилия Имя Отчество, пол, возраст, релевантность резюме, оценка на собеседовании:");

            String input = scanner.nextLine().trim();
            if (input.length() == 0 || input.matches("^\\s*")) break;
            try {
                checkInput(input);
                candidates.addCandidate(buildCandidate(input));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        candidates.showCandidates();
    }

    private void checkInput(String input) {
        if (!input.matches("([A-Za-zЁёА-я]+\\s+){1,2}([A-Za-zЁёА-я]+,\\s*)" +
                "((муж|жен)[ск(о|и)й]*,\\s*)" +
                "([0-9]+,\\s*)([0-5],\\s*)([0-5])")) {
            throw new IllegalArgumentException("Ошибка ввода данных!");
        }
    }

    private Candidate buildCandidate(String input) {
        String[] temp = input.split(",\\s*");
        return new Candidate(temp);
    }
}

