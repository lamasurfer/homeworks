package unit_3.homework3_1.task312.vehicleTypes.fuelTypes;

import unit_3.homework3_1.task312.VehicleTypeEnum;
import unit_3.homework3_1.task312.vehicleTypes.VehicleTypeByFuelTypes;

public class DieselType extends VehicleTypeByFuelTypes {

    @Override
    public String getTypeName() {
        return VehicleTypeEnum.DIESEL.name();
    }
}