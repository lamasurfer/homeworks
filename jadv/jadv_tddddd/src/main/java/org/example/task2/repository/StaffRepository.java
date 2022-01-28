package org.example.task2.repository;

import org.example.task2.entity.vet.Vet;
import org.example.task2.entity.vet.VetSpecialty;

import java.util.List;

public interface StaffRepository {

    void add(Vet vet);

    Vet getById(String id);

    List<Vet> getBySpecialty(VetSpecialty specialty);

    List<Vet> getAll();

}
