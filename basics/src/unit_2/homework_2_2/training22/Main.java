package unit_2.homework_2_2.training22;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        char[][] motions = new char[3][3];

        Scanner sc1 = new Scanner(System.in);


        for (int i = 0; i < 9; i++) {
            try {

                System.out.println("Ход игрока 1, введите коодинаты X (через пробел)");
                int x1 = sc1.nextInt();
                int y1 = sc1.nextInt();
                motions[x1][y1] = 'X';
                if (checkStatus(motions)) {
                    break;
                }
                printField(motions);
                System.out.println("Ход игрока 2, введите коодинаты O (через пробел)");
                int x2 = sc1.nextInt();
                int y2 = sc1.nextInt();
                motions[x2][y2] = 'O';
                printField(motions);
                if (checkStatus(motions)) {
                    break;
                }
            } catch (final InputMismatchException | ArrayIndexOutOfBoundsException ex) {
                System.out.println("Неправильный ввод, введите коодинаты через пробел.");
                sc1.nextLine();
            }
        }
        System.out.println("Игра закончена");
    }


    public static void printField(char[][] motions) {
        for (int i = 0; i < motions.length; i++) {
            for (int j = 0; j < motions[i].length; j++) {
                System.out.printf("%3s", motions[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean checkStatus(char[][] motions) {        //lines
        if (motions[0][0] != 0 && motions[0][0] == motions[0][1] && motions[0][1] == motions[0][2]) {
            System.out.printf("Выиграл %s\n", motions[0][0]);
            return true;
        }
        if (motions[1][0] != 0 && motions[1][0] == motions[1][1] && motions[1][1] == motions[1][2]) {
            System.out.printf("Выиграл %s\n", motions[1][0]);
            return true;
        }
        if (motions[2][0] != 0 && motions[2][0] == motions[2][1] && motions[2][1] == motions[2][2]) {
            System.out.printf("Выиграл %s\n", motions[2][0]);
            return true;
        }
        //rows
        if (motions[0][0] != 0 && motions[0][0] == motions[1][0] && motions[1][0] == motions[2][0]) {
            System.out.printf("Выиграл %s\n", motions[0][0]);
            return true;
        }
        if (motions[0][1] != 0 && motions[0][1] == motions[1][1] && motions[1][1] == motions[2][1]) {
            System.out.printf("Выиграл %s\n", motions[0][1]);
            return true;
        }
        if (motions[0][2] != 0 && motions[0][2] == motions[1][2] && motions[1][2] == motions[2][2]) {
            System.out.printf("Выиграл %s\n", motions[0][2]);
            return true;
        }
        //diagonals
        if (motions[0][0] != 0 && motions[0][0] == motions[1][1] && motions[1][1] == motions[2][2]) {
            System.out.printf("Выиграл %s\n", motions[0][0]);
            return true;
        }
        if (motions[0][2] != 0 && motions[0][2] == motions[1][1] && motions[1][1] == motions[2][0]) {
            System.out.printf("Выиграл %s\n", motions[0][2]);
            return true;
        }
        return false;
    }
}

