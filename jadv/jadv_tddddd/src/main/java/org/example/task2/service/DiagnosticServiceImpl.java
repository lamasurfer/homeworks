package org.example.task2.service;

import org.example.task2.entity.client.Client;
import org.example.task2.entity.client.pet.HealthCard;
import org.example.task2.entity.client.pet.Pet;
import org.example.task2.entity.client.pet.PetCondition;
import org.example.task2.entity.vet.Vet;
import org.example.task2.entity.vet.VetSpecialty;
import org.example.task2.repository.ClientRepository;
import org.example.task2.repository.StaffRepository;

import java.util.List;
import java.util.Random;

public class DiagnosticServiceImpl implements DiagnosticService {

    private final ClientRepository clientRepository;
    private final List<Vet> diagnosticStaff;

    public DiagnosticServiceImpl(ClientRepository clientRepository, StaffRepository staffRepository) {
        this.clientRepository = clientRepository;
        this.diagnosticStaff = staffRepository.getBySpecialty(VetSpecialty.DIAGNOSTICS);
    }

    @Override
    public void performTests(Client client) {
        List<Pet> pets = client.getPets();
        Vet vet = diagnosticStaff.get(new Random().nextInt(diagnosticStaff.size()));
        for (Pet pet : pets) {
            pet.setPetCondition(new Random().nextBoolean() ? PetCondition.ILL : PetCondition.HEALTHY);
            HealthCard healthCard = pet.getHealthCard();
            healthCard.addNotes("Сотрудник " + vet.getName() + " провел диагностику. Животное " +
                    pet.getPetCondition().toString() + ".");
        }
        clientRepository.update(client);
    }
}
