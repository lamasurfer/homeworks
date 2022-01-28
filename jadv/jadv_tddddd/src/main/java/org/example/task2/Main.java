package org.example.task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.example.task2.entity.client.Client;
import org.example.task2.entity.client.pet.Pet;
import org.example.task2.entity.client.pet.PetType;
import org.example.task2.repository.ClientFileRepository;
import org.example.task2.repository.ClientRepository;
import org.example.task2.repository.StaffRepository;
import org.example.task2.repository.StaffRepositoryImpl;
import org.example.task2.service.*;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModules(new ParameterNamesModule());

        File clients = new File("clients.txt");
        File staff = new File("staff.txt");



        Client client1 = new Client("Игорь Иванов");
        client1.addPet(new Pet("Деррик", PetType.DOG));
        client1.addPet(new Pet("Шарик", PetType.DOG));
        client1.addPet(new Pet("Лесси", PetType.DOG));

        Client client2 = new Client("Андрей Морозов");
        client2.addPet(new Pet("Мурка", PetType.CAT));
        client2.addPet(new Pet("Кеша", PetType.PARROT));

        Client client3 = new Client("Ирина Пчелова");
        client3.addPet(new Pet("Volatile Vek", PetType.VEK));

        Client client4 = new Client("Илья Семенов");
        client4.addPet(new Pet("Пухлик", PetType.HAMSTER));
        client4.addPet(new Pet("Дохлик", PetType.HAMSTER));

        Client client5 = new Client("Светлана Степанова");
        client5.addPet(new Pet("Шарик", PetType.FROG));

        System.out.println("До регистрации");
        System.out.println(client1);

        StaffRepository staffRepository = new StaffRepositoryImpl(staff, objectMapper);
        ClientRepository clientRepository = new ClientFileRepository(clients, objectMapper);
        RegistrationService registrationService = new RegistrationServiceImpl(clientRepository, staffRepository);
        TreatmentService treatmentService = new TreatmentServiceImpl(clientRepository, staffRepository);
        DiagnosticService diagnosticService = new DiagnosticServiceImpl(clientRepository, staffRepository);

        registrationService.register(client1);
        registrationService.register(client2);
        registrationService.register(client3);
        registrationService.register(client4);
        registrationService.register(client5);

        System.out.println("Зарегистрирован");
        System.out.println(client1);

        diagnosticService.performTests(client1);
        diagnosticService.performTests(client2);
        diagnosticService.performTests(client3);
        diagnosticService.performTests(client4);
        diagnosticService.performTests(client5);

        System.out.println("После диагностики");
        System.out.println(client1);

        treatmentService.performTreatment(client1);
        treatmentService.performTreatment(client2);
        treatmentService.performTreatment(client3);
        treatmentService.performTreatment(client4);
        treatmentService.performTreatment(client5);

        System.out.println("После лечения");
        System.out.println(client1);

    }
}
