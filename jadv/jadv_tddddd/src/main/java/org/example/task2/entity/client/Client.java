package org.example.task2.entity.client;

import org.example.task2.entity.client.pet.Pet;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private String id;
    private String name;
    private List<Pet> pets;

    public Client() {
    }

    public Client(String id, String name, List<Pet> pets) {
        this.id = id;
        this.name = name;
        this.pets = pets;
    }

    public Client(String name, List<Pet> pets) {
        this(null, name, pets);
    }

    public Client(String name) {
        this(null, name, new ArrayList<>());
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

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pets=" + pets +
                '}';
    }
}
