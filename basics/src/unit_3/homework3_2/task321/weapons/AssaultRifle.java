package unit_3.homework3_2.task321.weapons;

public class AssaultRifle extends Weapon {

    public AssaultRifle() {
        super("Автомат");

    }


    @Override
    public void shot() {
        System.out.println("Пыщь!Пыщь!Пыщь!");
    }
}
