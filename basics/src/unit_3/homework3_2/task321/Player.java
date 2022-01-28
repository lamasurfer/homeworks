package unit_3.homework3_2.task321;

import unit_3.homework3_2.task321.weapons.*;

public class Player {

    final private Weapon[] weaponSlots;

    public Player() {

        weaponSlots = new Weapon[]{
                new Pistol(),
                new AssaultRifle(),
                new RPG(),
                new WaterGun(),
                new Slingshot()
        };
    }


    public int getSlotsCount() {
        return weaponSlots.length;
    }

    public void getWeaponsList() {
        for (int i = 0; i < weaponSlots.length; i++) {
            System.out.println(i + " - " + weaponSlots[i]);
        }
    }

    public void shotWithWeapon(int slot) {
        try {
            Weapon weapon = weaponSlots[slot];
            weapon.shot();
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("Попробуй еще раз, так мы точно ни в кого не попадем!");
        }

        // TODO проверить на выход за границы
        // выбросить IllegalArgumentException,
        // если значение slot некорректно
        //if (slot < 0 || slot > weaponSlots.length-1) {
        //  throw new IllegalArgumentException("Value " + slot + " is out of range");
        //}
        //Weapon weapon = weaponSlots[slot];
        //weapon.shot();
    }
}


