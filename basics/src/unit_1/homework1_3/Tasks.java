package unit_1.homework1_3;

import java.util.Scanner;

class Tasks {
    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);

        int totalTime = 0; // общее время на все задачи
        int biggestTime = 0; // время самой большой задачи
        int smallestTime = Integer.MAX_VALUE; // время самой короткой задачи

        while (true) {
            //ввод данных
            System.out.println("Введите название задачи:");
            String taskName = sc1.nextLine();
            System.out.println("Сколько дней потребуется на выполнение?");
            int days = sc1.nextInt();
            System.out.println("Сколько часов?");
            int hours = sc1.nextInt();
            System.out.println("Сколько минут?");
            int minutes = sc1.nextInt();

            //перевод
            int currentTaskTime = convertToSeconds(days, hours, minutes);

            totalTime += currentTaskTime; // общее время растет с каждой новой

            //сравнение и присвоение значений
            biggestTime = currentTaskTime > biggestTime ? currentTaskTime : biggestTime;
            smallestTime = currentTaskTime < smallestTime ? currentTaskTime : smallestTime;

            System.out.println("Для завершения работы введите \"end\", для продолжения нажмите enter");
            sc1.nextLine();
            String input = sc1.nextLine();
            if ("end".equals(input)) {
                break; // выход
            }
        }

        System.out.println("\nВсего потребуется: " + totalTime + " секунд");
        System.out.println("Самая продолжительная задача займет: " + biggestTime + " секунд");
        System.out.println("Самая короткая задача займет: " + smallestTime + " секунд");
    }

    public static int convertToSeconds(int days, int hours, int minutes) {
        int seconds = days * 86400 + hours * 3600 + minutes * 60;
        return seconds; // переводит дни, часы, минуты в секунды
    }
}
