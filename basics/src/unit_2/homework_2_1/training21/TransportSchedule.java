package unit_2.homework_2_1.training21;

import java.time.LocalTime;


public class TransportSchedule implements Comparable<TransportSchedule> {
    public Type type;
    public String route;
    public LocalTime time;

    public TransportSchedule(Type type, String route, LocalTime time) {
        this.type = type;
        this.route = route;
        this.time = time;
    }

    public Type getType() {
        return type;
    }

    public String getRoute() {
        return route;
    }

    public LocalTime getTime() {
        return time;
    }


    public int compareTo(TransportSchedule transportSchedule) {
        return this.time.compareTo(transportSchedule.time);
    }

}
