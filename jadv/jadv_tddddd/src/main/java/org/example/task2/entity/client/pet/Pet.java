package org.example.task2.entity.client.pet;

public class Pet {

    private String name;
    private PetType petType;
    private PetCondition petCondition = PetCondition.UNKNOWN;
    private HealthCard healthCard;

    public Pet() {
    }

    public Pet(String name, PetType petType) {
        this.name = name;
        this.petType = petType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public PetCondition getPetCondition() {
        return petCondition;
    }

    public void setPetCondition(PetCondition petCondition) {
        this.petCondition = petCondition;
    }

    public HealthCard getHealthCard() {
        return healthCard;
    }

    public void setHealthCard(HealthCard healthCard) {
        this.healthCard = healthCard;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", petType=" + petType +
                ", petCondition=" + petCondition +
                ", healthCard=" + healthCard +
                '}';
    }
}
