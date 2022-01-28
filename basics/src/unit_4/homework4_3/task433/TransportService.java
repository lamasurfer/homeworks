package unit_4.homework4_3.task433;

import unit_4.homework4_3.task433.transport.Transport;
import unit_4.homework4_3.task433.transport.TransportType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TransportService {

    //    private Set<Transport> set = new HashSet<>();
//
//    public void addTransport(Transport transport) {
//        if (!set.add(transport)) System.out.println("Автомобиль с таким номером уже есть!");
//    }
//
//    public void showTransport() {
//        TransportType[] types = {
//                TransportType.PASSENGER_CAR,
//                TransportType.TRUCK,
//                TransportType.SPECIAL_CAR
//        };
//        System.out.println();
//        for (TransportType type : types) {
//            System.out.println(type);
//            for (Transport transport : set) {
//                if(transport.getType().equals(type))  {
//                    System.out.println(transport);
//                }
//            }
//        }
//        System.out.println();
//    }
//}
    private Map<TransportType, Set<Transport>> map = new HashMap<>();

    public void addTransport(Transport transport) {
        Set<Transport> temp = new HashSet<>();
        TransportType key = transport.getType();
        if (map.containsKey(key)) temp = map.get(key);
        if (!temp.contains(transport)) {
            temp.add(transport);
            map.put(key, temp);
        } else {
            System.out.println("\nТакой автомобиль уже есть!");
        }
    }

    public void showTransport() {
        TransportType[] types = {
                TransportType.PASSENGER_CAR,
                TransportType.TRUCK,
                TransportType.SPECIAL_CAR
        };

        for (Map.Entry<TransportType, Set<Transport>> entry : map.entrySet()) {
            for (TransportType type : types) {
                if (type.equals(entry.getKey())) {
                    System.out.println(type + ":");
                    for (Object transport : entry.getValue().toArray()) {
                        System.out.printf("\t%s\n", transport);
                    }
                }
            }
        }
    }
}




