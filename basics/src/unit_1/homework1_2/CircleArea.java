package unit_1.homework1_2;

import java.util.Scanner;

class CircleArea {

    static final double PI = 3.14; //чтобы дважды не писать в методах

    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);

        System.out.println(
                "Добрый день! \n" + "Данная программа вычисляет площадь и длину произвольной окружности по её радиусу. \n"
                        + "Введите радиус окружности в сантиметрах и нажмите enter:");

        double radius = sc1.nextDouble();

        double circleArea = calculateCircleArea(radius);
        double circleLength = calculateCircleLength(radius);

        //System.out.println("Площадь окружности: " + circleArea + " см2");
        //System.out.println("Длина окружности: " + circleLength + " см");
        System.out.printf("Площадь окружности: %.2f см2\n", circleArea);
        System.out.printf("Длина окружности: %.2f см\n", circleLength);
        System.out.format("Длина окружности: %.2f см%n", circleLength);
    }

    static double calculateCircleArea(double radius) {
        return PI * radius * radius;
    }

    static double calculateCircleLength(double radius) {
        return 2 * PI * radius;
    }
}
