package unit_3.homework3_1.task312.vehicleTypes;

import unit_3.homework3_1.task312.VehicleType;

public class VehicleTypeByFuelTypes extends VehicleType {
    public VehicleTypeByFuelTypes() {
        super("Vehicle type by fuel types");
    }

    @Override
    public boolean equals(Object object) {
        //if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        VehicleTypeByFuelTypes vehicleTypeByFuelTypes = (VehicleTypeByFuelTypes) object;
        return attribute != null ? attribute.equals(vehicleTypeByFuelTypes.attribute) : false;
    }


}
