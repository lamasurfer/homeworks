package unit_2.homework_2_2.task221;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int SIZE = 8;
        int[][] colors = new int[SIZE][SIZE];
        int[][] rotatedColors;

        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }

        System.out.println("Исходный массив:");
        printArray(colors);

        Scanner sc1 = new Scanner(System.in);

        while (true) {
            System.out.println("Введите угол поворота матрицы: 90, 180, 270, 360. 0 - исходный. end - выход.");
            try {
                String input = sc1.next();
                if ("end".equals(input)) {
                    break;
                }

                int angle = Integer.parseInt(input);
                rotatedColors = rotateArray(colors, angle);
                if (angle == 0 || angle == 90 || angle == 180 || angle == 270 || angle == 360) {
                    printArray(rotatedColors);
                }
            } catch (NumberFormatException | InputMismatchException ex) {
                System.out.println("Неправильный ввод, попробуйте еще раз.");
                sc1.nextLine();
            }
        }
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.format("%5s", array[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] rotateArray(int[][] array, int angle) {
        int[][] output
                = new int[array.length][array.length];
        int limit = array.length - 1;
        for (int
             i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                output[i][j] = array[limit - j][i];
            }
        }
        if (angle == 0 || angle == 360) {
            return array;
        } else if (angle == 90) {
            return output;
        } else if (angle == 180) {
            return rotateArray(output, 90);
        } else if (angle == 270) {
            return rotateArray(output, 180);
        } else {
            System.out.println("Не кратно 90 или больше 360, попробуйте еще раз.");
            return array;
        }
    }


    //  метод, чтобы крутить еще и против часовой
//    public static int[][] rotateSide(int[][] array, int side, int angle) {
//        int[][] output = new int[array.length][array.length];
//        int limit = array.length - 1;
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array.length; j++) {
//                output[i][j] = array[limit - j][i];
//            }
//        }
//        if ((side == 1 && angle == 90) || (side == 0 && angle == 270)) {
//            return output;
//        } else if ((side == 1 && angle == 180) || (side == 0 && angle == 180)) {
//            return output = rotateSide(output, 1, 90);
//        } else if ((side == 1 && angle == 270) || (side == 0 && angle == 90)) {
//            return output = rotateSide(output, 1, 180);
//        } else {
//            return array;
//        }
//    }


// отдельный алгоритм для каждого поворота
//    public static int[][] rotateArray(int[][] array, int angle) {
//        int[][] output = new int[array.length][array.length];
//        int limit = array.length - 1;
//        if (angle == 0 || angle == 360) {
//            return array;
//        }
//        if (angle == 90) {
//            for (int i = 0; i < array.length; i++) {
//                for (int j = 0; j < array.length; j++) {
//                    output[i][j] = array[limit - j][i];
//                }
//            }
//            return output;
//        }
//        if (angle == 180) {
//            for (int i = 0; i < array.length; i++) {
//                for (int j = 0; j < array.length; j++) {
//                    output[i][j] = array[limit - i][limit - j];
//                }
//            }
//            return output;
//        }
//        if (angle == 270) {
//            for (int i = 0; i < array.length; i++) {
//                for (int j = 0; j < array.length; j++) {
//                    output[i][j] = array[j][limit - i];
//                }
//            }
//            return output;
//        } else {
//            System.out.println("Не кратно 90 или больше 360, попробуйте еще раз.");
//            return array;
//        }
//    }


}

