package unit_2.homework_2_1.training21;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        TransportSchedule[] schedule = new TransportSchedule[10];
        int counter = 0;

        Scanner sc1 = new Scanner(System.in);

        while (true) {
            System.out.println("Введите через пробел тип транспорта, номер маршрута и время прибытия в формате (hh:MM)");
            System.out.println("end для выхода из программы");

            Type type = Type.valueOf(sc1.next().trim());
            if ("end".equals(type.toString()) || counter == 10) {
                System.out.println("Программа завершена.");
                break;
            }

            String route = sc1.next();
            LocalTime time = LocalTime.parse(sc1.next());

            TransportSchedule transportSchedule = new TransportSchedule(type, route, time);
            schedule[counter] = transportSchedule;
            counter++;

            sc1.nextLine();
            System.out.println("");

            Arrays.sort(schedule, 0, counter);

            System.out.println("Тип транспорта --- Маршрут --- Время прибытия");
            for (int i = 0; i < counter; i++) {
                System.out.printf("%14s %11s %18s\n", schedule[i].getType(), schedule[i].getRoute(), schedule[i].getTime());
            }
            System.out.println("");
        }
    }
}