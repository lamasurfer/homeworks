package org.example.task2.entity.client.pet;

public enum PetCondition {
    UNKNOWN("пока неизвестно"),
    HEALTHY("здорово"),
    ILL("болеет");

    private final String description;

    PetCondition(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
