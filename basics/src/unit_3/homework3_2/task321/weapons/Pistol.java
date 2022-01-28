package unit_3.homework3_2.task321.weapons;

public class Pistol extends Weapon {

    public Pistol() {
        super("Пистолет");
    }

    @Override
    public void shot() {
        System.out.println("Пыщь!");
    }
}