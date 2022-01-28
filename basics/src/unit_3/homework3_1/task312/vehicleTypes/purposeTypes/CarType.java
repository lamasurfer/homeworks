package unit_3.homework3_1.task312.vehicleTypes.purposeTypes;

import unit_3.homework3_1.task312.VehicleTypeEnum;
import unit_3.homework3_1.task312.vehicleTypes.VehicleTypeByPurpose;

public class CarType extends VehicleTypeByPurpose {

    @Override
    public String getTypeName() {
        return VehicleTypeEnum.CAR.name();
    }
}
