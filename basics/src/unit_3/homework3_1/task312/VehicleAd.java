package unit_3.homework3_1.task312;

import unit_3.homework3_1.task312.vehicleTypes.VehicleTypeByBodyTypes;
import unit_3.homework3_1.task312.vehicleTypes.VehicleTypeByFuelTypes;
import unit_3.homework3_1.task312.vehicleTypes.VehicleTypeByPurpose;
//import unit_3.homework3_1.task32.vehicleTypes.VehicleTypeByFuelTypes;
//import unit_3.homework3_1.task32.vehicleTypes.VehicleTypeByPurpose;

public class VehicleAd {
    private String model;
    private String id;
    private VehicleTypeByPurpose vehicleTypeByPurpose;
    private VehicleTypeByBodyTypes vehicleTypeByBodyTypes;
    private VehicleTypeByFuelTypes vehicleTypeByFuelTypes;

    public VehicleAd(String model, String id, VehicleTypeByPurpose vehicleTypeByPurpose,
                     VehicleTypeByBodyTypes vehicleTypeByBodyTypes, VehicleTypeByFuelTypes vehicleTypeByFuelTypes) {
        this.model = model;
        this.id = id;
        this.vehicleTypeByPurpose = vehicleTypeByPurpose;
        this.vehicleTypeByBodyTypes = vehicleTypeByBodyTypes;
        this.vehicleTypeByFuelTypes = vehicleTypeByFuelTypes;
    }

    //for creating new Car
    public VehicleAd(String model) {
        this.model = model;
    }

    public VehicleTypeByPurpose getVehicleTypeByPurpose() {
        return vehicleTypeByPurpose;
    }

    public VehicleTypeByBodyTypes getVehicleTypeByBodyTypes() {
        return vehicleTypeByBodyTypes;
    }

    public VehicleTypeByFuelTypes getVehicleTypeByFuelTypes() {
        return vehicleTypeByFuelTypes;
    }

    public String getModel() {
        return model;
    }

    public String getId() {
        return id;
    }

    public String toString() {
        return this.model;
    }
}
