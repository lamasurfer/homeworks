package unit_4.homework4_3.task433.transport;

public abstract class Transport {

    private final String number;
    private final TransportType type;
    private String model;
    private String color;

    public Transport(String number, String model, String color, TransportType type) {
        this.number = number;
        this.model = model;
        this.color = color;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public TransportType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transport transport = (Transport) o;

        return number.equals(transport.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", number, model, color);
    }

}
