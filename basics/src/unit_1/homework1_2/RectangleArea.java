package unit_1.homework1_2;

import java.util.Scanner;

class RectangleArea {

    public static void main(String[] args) {

        System.out.println("Данная программа вычисляет периметр и площадь произвольного прямоугольного участка. \n"
                + "Введите длину первой стороны в метрах и нажмите enter:");

        Scanner sc1 = new Scanner(System.in);
        int a = sc1.nextInt();

        System.out.println("Введите длину второй стороны и нажмите enter:");
        int b = sc1.nextInt();

        int perimeter = 2 * (a + b);
        int area = a * b;

        System.out.println("Периметр: " + perimeter + " м");
        System.out.println("Площадь: " + area + " м2");

    }
}
