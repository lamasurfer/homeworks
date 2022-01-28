package unit_3.homework3_2.task321.weapons;

public abstract class Weapon {
    private String name;

    public Weapon(String name) {
        this.name = name;
    }

    public abstract void shot();

    @Override
    public String toString() {
        return name;
    }

}