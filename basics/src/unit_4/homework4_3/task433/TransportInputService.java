package unit_4.homework4_3.task433;

import unit_4.homework4_3.task433.transport.PassengerCar;
import unit_4.homework4_3.task433.transport.SpecialCar;
import unit_4.homework4_3.task433.transport.Transport;
import unit_4.homework4_3.task433.transport.Truck;

import java.util.Scanner;

public class TransportInputService {

    static Scanner scanner = new Scanner(System.in);

    private static void checkTransportInput(String input) {
        if (!input.matches("([A-ZА-Я])(\\d{3})([A-ZА-Я]{2})(\\d{2,3}),\\s*.+,\\s*.+,\\s*+([а-я]+)")) {
            throw new IllegalArgumentException("\nОшибка ввода данных!");
        }
    }

    private static Transport buildTransport(String[] temp) {
        if (temp[3].matches("(лег.*)$")) {
            return new PassengerCar(temp[1], temp[2], temp[3]);
        } else if (temp[3].matches("(гру.*)$")) {
            return new Truck(temp[1], temp[2], temp[3]);
        } else if (temp[3].matches("(спе.*)$")) {
            return new SpecialCar(temp[1], temp[2], temp[3]);
        } else {
            throw new IllegalArgumentException("\nНедоступный тип транспорта!");
        }
    }

    public void runUserInput() {

        TransportService tS = new TransportService();
        System.out.println("Доступные типы автомобилей: легковой, грузовой, специальный. Для выхода нажмите enter.");
        while (true) {
            try {
                System.out.println("\nВведите информацию об автомобиле (в формате: номер, марка, цвет, тип автомобиля):");
                String input = scanner.nextLine().trim();
                if (input.length() == 0 || input.matches("^\\s*")) break;
                checkTransportInput(input);
                String[] temp = input.split(",\\s*");
                Transport transport = buildTransport(temp);
                tS.addTransport(transport);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        tS.showTransport();
        System.out.println("\nЗавершение работы...");
    }
}
