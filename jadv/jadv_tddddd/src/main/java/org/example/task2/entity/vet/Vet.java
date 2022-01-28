package org.example.task2.entity.vet;

public class Vet {

    private String id;
    private String name;
    private VetSpecialty specialty;

    public Vet() {
    }

    public Vet(String id, String name, VetSpecialty specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }

    public Vet(String name, VetSpecialty specialty) {
        this (null, name, specialty);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VetSpecialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(VetSpecialty specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", specialty=" + specialty +
                '}';
    }
}
