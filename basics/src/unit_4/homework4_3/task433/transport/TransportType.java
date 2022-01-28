package unit_4.homework4_3.task433.transport;

public enum TransportType {

    PASSENGER_CAR("Легковые автомобили"),
    TRUCK("Грузовые автомобили"),
    SPECIAL_CAR("Специальные автомобили");

    private final String description;

    TransportType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description + ":";
    }
}
