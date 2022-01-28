package unit_3.homework3_1.task312.vehicleTypes.bodyTypes;

import unit_3.homework3_1.task312.VehicleTypeEnum;
import unit_3.homework3_1.task312.vehicleTypes.VehicleTypeByBodyTypes;

public class SedanType extends VehicleTypeByBodyTypes {

    @Override
    public String getTypeName() {
        return VehicleTypeEnum.SEDAN.name();
    }
}