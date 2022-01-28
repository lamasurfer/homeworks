package unit_3.homework3_1.task312;

import unit_3.homework3_1.task312.vehicleTypes.bodyTypes.PickupType;
import unit_3.homework3_1.task312.vehicleTypes.bodyTypes.SedanType;
import unit_3.homework3_1.task312.vehicleTypes.bodyTypes.WagonType;
import unit_3.homework3_1.task312.vehicleTypes.fuelTypes.DieselType;
import unit_3.homework3_1.task312.vehicleTypes.fuelTypes.HybridType;
import unit_3.homework3_1.task312.vehicleTypes.fuelTypes.PetrolType;
import unit_3.homework3_1.task312.vehicleTypes.purposeTypes.CarType;
import unit_3.homework3_1.task312.vehicleTypes.purposeTypes.PassengerType;
import unit_3.homework3_1.task312.vehicleTypes.purposeTypes.TruckType;

public class Main {
    public static void main(String[] args) {
        AdsService adsService = new AdsService();
        VehicleAd volvoAd = new VehicleAd("Volvo", "123", new PassengerType(), new SedanType(),
                new PetrolType());
        VehicleAd kamazAd = new VehicleAd("Kamaz", "45", new TruckType(), new PickupType(),
                new DieselType());


        adsService.setAdList(new VehicleAd[]{volvoAd, kamazAd});

        System.out.println();
        adsService.filterByVehicleTypeByPurpose(new PassengerType());
        adsService.filterByVehicleTypeByPurpose(new TruckType());

        System.out.println();
        adsService.filterByVehicleTypeByBodyTypes(new SedanType());
        adsService.filterByVehicleTypeByBodyTypes(new PickupType());

        System.out.println();
        adsService.filterByVehicleTypeByFuelTypes(new PetrolType());
        adsService.filterByVehicleTypeByFuelTypes(new HybridType());

//объявление с типами CAR, SEDAN, PETROL и отфильтруйте объявления с бензиновым
        VehicleAd peugeotAd = new VehicleAd("Peugeot", "87", new CarType(), new SedanType(),
                new PetrolType());

        VehicleAd toyotaAd = new VehicleAd("Prius", "21", new CarType(), new WagonType(),
                new HybridType());

        System.out.println();
        AdsService adsService2 = new AdsService();
        adsService2.setAdList(new VehicleAd[]{peugeotAd, toyotaAd});
        adsService2.filterByVehicleTypeByFuelTypes(new PetrolType());
    }
}
