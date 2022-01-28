package unit_3.homework3_2.task321.weapons;

public class RPG extends Weapon {

    public RPG() {
        super("РПГ");
    }

    @Override
    public void shot() {
        System.out.println("ПЫЩЬ!!!11");
    }
}
