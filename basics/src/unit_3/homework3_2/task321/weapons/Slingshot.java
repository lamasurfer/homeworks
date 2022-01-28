package unit_3.homework3_2.task321.weapons;

public class Slingshot extends Weapon {

    public Slingshot() {
        super("Рогатка");
    }

    @Override
    public void shot() {
        System.out.println("***бесшумный убийца***");
    }
}
