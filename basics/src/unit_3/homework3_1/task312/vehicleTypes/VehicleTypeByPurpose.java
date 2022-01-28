package unit_3.homework3_1.task312.vehicleTypes;

import unit_3.homework3_1.task312.VehicleType;

public class VehicleTypeByPurpose extends VehicleType {
    public VehicleTypeByPurpose() {
        super("Vehicle type by purpose");
    }

    @Override
    public boolean equals(Object object) {
        //if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        VehicleTypeByPurpose vehicleTypeByPurpose = (VehicleTypeByPurpose) object;
        return attribute != null ? attribute.equals(vehicleTypeByPurpose.attribute) : false;
    }
}

