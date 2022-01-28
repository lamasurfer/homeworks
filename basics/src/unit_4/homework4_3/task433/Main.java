package unit_4.homework4_3.task433;

import unit_4.homework4_3.task433.transport.PassengerCar;
import unit_4.homework4_3.task433.transport.SpecialCar;
import unit_4.homework4_3.task433.transport.Truck;

public class Main {
    public static void main(String[] args) {
//
//        TransportInputService user = new TransportInputService();
//        user.runUserInput();

        TransportService tS = new TransportService();

        Truck test1 = new Truck("B788AB99", "Камаз 120", "красный");
        Truck test12 = new Truck("B788AB97", "Камаз 120", "красный");
        Truck test13 = new Truck("B788AB97", "Камаз 120", "красный");
        PassengerCar test2 = new PassengerCar("А192АА199", "ВАЗ2105", "белый");
        PassengerCar test22 = new PassengerCar("А192АА197", "ВАЗ2105", "белый");
        SpecialCar test3 = new SpecialCar("Н177ЕТ777", "Беларус МТЗ-80", "синий");
        SpecialCar test4 = new SpecialCar("Н177ЕТ777", "Беларус МТЗ-80", "красный");

        tS.addTransport(test1);
        tS.addTransport(test12);
        tS.addTransport(test12);
        tS.addTransport(test13);
        tS.addTransport(test2);
        tS.addTransport(test22);
        tS.addTransport(test3);
        tS.addTransport(test4);


        tS.showTransport();


    }
}
