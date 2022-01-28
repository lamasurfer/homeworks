package unit_3.homework3_1.task312.vehicleTypes.purposeTypes;

import unit_3.homework3_1.task312.VehicleTypeEnum;
import unit_3.homework3_1.task312.vehicleTypes.VehicleTypeByPurpose;

public class PassengerType extends VehicleTypeByPurpose {

    @Override
    public String getTypeName() {
        return VehicleTypeEnum.PASSENGER.name();
    }
}