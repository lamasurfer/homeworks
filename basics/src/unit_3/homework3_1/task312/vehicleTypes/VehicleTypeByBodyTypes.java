package unit_3.homework3_1.task312.vehicleTypes;

import unit_3.homework3_1.task312.VehicleType;

public class VehicleTypeByBodyTypes extends VehicleType {
    public VehicleTypeByBodyTypes() {
        super("Vehicle type by body types");
    }

    @Override
    public boolean equals(Object object) {
        //if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        VehicleTypeByBodyTypes vehicleTypeByBodyTypes = (VehicleTypeByBodyTypes) object;
        return attribute != null && attribute.equals(vehicleTypeByBodyTypes.attribute);
    }
}
//return attribute != null ? attribute.equals(vehicleTypeByBodyTypes.attribute) : false;