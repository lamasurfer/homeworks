package unit_2.homework_2_1.task212;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Product[] products = new Product[10];

        products[0] = new Product("Молоко 2,5%", 50, "Вкуснотеево");
        products[1] = new Product("Молоко 3,2%", 55, "Вкуснотеево");
        products[2] = new Product("Молоко 4,2%", 60, "Вкуснотеево");
        products[3] = new Product("Хлеб нарезной", 25, "Хлебзавод 22");
        products[4] = new Product("Хлеб черный", 31, "Хлебзавод 28");
        products[5] = new Product("Колбаса Сальчичон", 700, "Останкино");
        products[6] = new Product("Колбаса Элитная", 950, "Черкизово");
        products[7] = new Product("Кефир 2,5%", 52, "ВкусВилл");
        products[8] = new Product("Кефир 3,2%", 55, "ВкусВилл");
        products[9] = new Product("Кефир 4,2%", 60, "ВкусВилл");

        System.out.println("\nДо сортировки: ");
        for (Product p : products) {
            System.out.println(p);
        }

        mySort(products);

        System.out.println("\nПосле сортировки: ");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public static void mySort(Product[] products) {
        System.out.println("\nВыберите метод сортировки: "
                + "\n(1) - С помощью интерфейса Comparable" // Timsort?
                + "\n(2) - Быстрая сортировка"
                + "\n(3) - \"Гномья\" сортировка");

        Scanner sc1 = new Scanner(System.in);
        String input = sc1.nextLine();
        switch (input) {
            case "1":
                Arrays.sort(products);
                break;
            case "2":
                quickSort(products);
                break;
            case "3":
                gnomeSort(products);
                break;
            default:
                break;
        }
    }

    public static void quickSort(Product[] products) {
        quickSortCycle(products, 0, products.length - 1);
    }

    public static void quickSortCycle(Product[] products, int start, int end) {
        int i;
        int j;
        i = start;
        j = end;
        Product[] buffer = new Product[1];
        int a = products[(start + end) / 2].price;
        do {
            while ((products[i].price < a) && (i < end))
                i++;
            while ((a < products[j].price) && ((j > start)))
                j--;
            if (i <= j) {
                buffer[0] = products[i];
                products[i] = products[j];
                products[j] = buffer[0];
                i++;
                j--;
            }
        } while (i <= j);
        if (start < j)
            quickSortCycle(products, start, j);
        if (i < end)
            quickSortCycle(products, i, end);
    }

    public static void gnomeSort(Product[] products) {
        int i = 1;
        int j = 2;
        Product[] buffer = new Product[1];
        while (i < products.length) {
            if (products[i - 1].price < products[i].price) {
                i = j;
                j += 1;
            } else {
                buffer[0] = products[i - 1];
                products[i - 1] = products[i];
                products[i] = buffer[0];
                i -= 1;
                if (i == 0) {
                    i = j;
                    j += 1;
                }
            }
        }
    }
}


