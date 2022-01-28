package org.example.task2.entity.client.pet;

public enum PetType {
    CAT("кошка"),
    DOG("собака"),
    HAMSTER("хомяк"),
    PARROT("попугай"),
    FROG("лягушка"),
    VEK("VEK");

    private final String description;

    PetType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}

