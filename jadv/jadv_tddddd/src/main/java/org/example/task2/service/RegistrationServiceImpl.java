package org.example.task2.service;


import org.example.task2.entity.client.Client;
import org.example.task2.entity.client.pet.HealthCard;
import org.example.task2.entity.client.pet.Pet;
import org.example.task2.entity.vet.Vet;
import org.example.task2.entity.vet.VetSpecialty;
import org.example.task2.repository.ClientRepository;
import org.example.task2.repository.StaffRepository;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class RegistrationServiceImpl implements RegistrationService {

    private final ClientRepository clientRepository;
    private final List<Vet> registrationStaff;

    public RegistrationServiceImpl(ClientRepository clientRepository, StaffRepository staffRepository) {
        this.clientRepository = clientRepository;
        this.registrationStaff = staffRepository.getBySpecialty(VetSpecialty.REGISTRATION);
    }

    public void register(Client client) {
        String id = UUID.randomUUID().toString();
        List<Pet> pets = client.getPets();
        Vet vet = registrationStaff.get(new Random().nextInt(registrationStaff.size()));
        for (Pet pet : pets) {
            HealthCard healthCard = new HealthCard();
            healthCard.addNotes("Карта " + pet.getName() + " заведена сотрудником: " + vet.getName());
            pet.setHealthCard(healthCard);
        }
        client.setId(id);
        clientRepository.add(client);
    }
}
