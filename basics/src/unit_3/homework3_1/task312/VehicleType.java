package unit_3.homework3_1.task312;

public class VehicleType {
    protected String attribute;

    public VehicleType(String attribute) {
        this.attribute = attribute;
    }

    public String getAttributeOfType() {
        return attribute;
    }

    public String getTypeName() {
        return "Some vehicle type name";
    }
}
