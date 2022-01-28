package unit_1.homework1_5;

import java.util.Scanner;

class NewTask {
    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);

        while (true) {
            System.out.println("Введите название задачи и время на ее выполнение: ");
            String input = sc1.nextLine();

            int taskTime = taskTime(input);
            if (taskTime < 0) {
                System.out.println("Неправильный ввод");
            } else {
                System.out.println("На задачу потребуется: " + taskTime + " ч.");
                break;
            }
        }
    }

    static int taskTime(String input) {
        int timePos = input.indexOf("начинается в");
        String startTimeString = input.substring(timePos + 12, timePos + 15);
        int startTime = Integer.parseInt(startTimeString.trim());
        timePos = input.indexOf("заканчивается в");
        String endTimeString = input.substring(timePos + 15);
        int endTime = Integer.parseInt(endTimeString.trim());
        return endTime - startTime;
    }
}
