package unit_2.homework_2_2.task222;


import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int SIZE = 10;
        int[][] warField = new int[SIZE][SIZE];

        final int EMPTY = 0;
        final int SHIP = 1;
        final int DEAD = 2;
        final int MISS = 3;

        final int MAX_COUNT = 10;
        int shipCount = 0; // число подбитых

        Random random = new Random();
        for (int i = 0; i < MAX_COUNT; i++) {
            int shipPlace1 = random.nextInt(SIZE);
            int shipPlace2 = random.nextInt(SIZE);
            if (warField[shipPlace1][shipPlace2] == SHIP) i--;
            warField[shipPlace1][shipPlace2] = SHIP;
        }

        System.out.println("***МОРСКОЙ БОЙ!***");
        System.out.println("Нужно потопить 10 кораблей противника за 100 ходов.");
        System.out.println("Выберите сложность: " +
                "\n(1) - легко" +
                "\n(2) - нормально (рекомендуется)" +
                "\n(3) - вслепую");

        Scanner sc1 = new Scanner(System.in);
        String diff = sc1.next();

        printWarField(warField, diff);

        // вслепую легенда не нужна
        if ("1".equals(diff) || "2".equals(diff)) {
            System.out.println("Легенда: 0 - пусто, 1 - враг, 2 - подбитый враг, 3 - промах.");
        }
        System.out.println("Для выхода введите 999");

        for (int i = 1; i <= SIZE * SIZE; i++) { // 100 ходов
            try {
                System.out.println("Ход " + i);
                System.out.println("Введите коодинаты через пробел");
                int x = sc1.nextInt();
                if (x == 999) break; // выход
                int y = sc1.nextInt();

                if (warField[x][y] == EMPTY) { // промах
                    System.out.println("Мимо!");
                    warField[x][y] = MISS;
                    printWarField(warField, diff);
                } else if (warField[x][y] == SHIP) { // подбил
                    shipCount++; // подсчет подбитых
                    System.out.println("Попал! Еще " + (MAX_COUNT - shipCount) + "!");
                    warField[x][y] = DEAD;
                    printWarField(warField, diff);
                } else if (warField[x][y] == DEAD || warField[x][y] == MISS) {
                    System.out.println("Внимательнее! Уже стрелял сюда!");
                    // printWarField(warField);
                }
                if (shipCount == MAX_COUNT) {
                    System.out.println("Победа!");
                    break;
                }
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException ex) {
                System.out.println("Неправильный ввод, введите коодинаты через пробел.");
                i--; // откат цикла назад при неправильном вводе
                sc1.nextLine();
            }
        }
        System.out.println("Игра закончена. Потоплено: " + shipCount);
    }

    public static void printWarField(int[][] warField, String diff) {
        switch (diff) {
            case "1": // легко, с координатами
                System.out.println("   0 1 2 3 4 5 6 7 8 9");
                System.out.println("  --------------------");
                for (int i = 0; i < warField.length; i++) {
                    System.out.print(i + "|");
                    for (int j = 0; j < warField.length; j++) {
                        System.out.printf("%2d", warField[i][j]);
                    }
                    System.out.println();
                }
                break;
            case "2": // нормально
                for (int i = 0; i < warField.length; i++) {
                    for (int j = 0; j < warField.length; j++) {
                        System.out.printf("%2d", warField[i][j]);
                    }
                    System.out.println();
                }
                break;
            case "3": // вслепую
            default:
                System.out.println("Мы в неизвестных водах...");
                break;
        }
    }
}
