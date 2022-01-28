package unit_3.homework3_2.task321.weapons;

public class WaterGun extends Weapon {

    public WaterGun() {
        super("Водяной пистолет");
    }

    @Override
    public void shot() {
        System.out.println("Плюмпс!");
    }
}