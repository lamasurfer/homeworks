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

public class TreatmentServiceImpl implements TreatmentService {

    private final ClientRepository clientRepository;
    private final List<Vet> treatmentStaff;

    public TreatmentServiceImpl(ClientRepository clientRepository, StaffRepository staffRepository) {
        this.clientRepository = clientRepository;
        this.treatmentStaff = staffRepository.getBySpecialty(VetSpecialty.TREATMENT);
    }

    @Override
    public void performTreatment(Client client) {
        List<Pet> pets = client.getPets();
        Vet vet = treatmentStaff.get(new Random().nextInt(treatmentStaff.size()));
        for (Pet pet : pets) {
            HealthCard healthCard = pet.getHealthCard();
            if (pet.getPetCondition() == PetCondition.ILL) {
                healthCard.addNotes("Сотрудником " + vet.getName() + " проведено лечение. " + pet.getName() + " теперь в порядке");

                pet.setPetCondition(PetCondition.HEALTHY);
            } else {
                healthCard.addNotes("Животное " + pet.getName() + " здорово, лечение не проводилось. Сотрудником " +
                        vet.getName() + " выданы рекомендации владельцу, произведен комплексный уход.");
            }
        }
        clientRepository.update(client);
    }
}
