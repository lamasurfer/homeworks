package org.example.task2.entity.vet;

public enum VetSpecialty {
    REGISTRATION("регистратура"),
    DIAGNOSTICS("диагностика"),
    TREATMENT("лечение");

    private final String description;

    VetSpecialty(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
