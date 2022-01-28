package org.example.task2.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.task2.entity.client.Client;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientFileRepository implements ClientRepository {

    private final File file;
    private final ObjectMapper objectMapper;

    public ClientFileRepository(File file, ObjectMapper objectMapper) {
        this.file = file;
        this.objectMapper = objectMapper;
    }

    @Override
    public void add(Client client) {
        try (FileWriter writer = new FileWriter(file, true)) {
            String clientAsString = objectMapper.writeValueAsString(client);
            writer.append(String.format("%s%n", clientAsString));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Client getById(String id) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                Client client = objectMapper.readValue(scanner.nextLine(), Client.class);
                if (client.getId().equals(id)) {
                    return client;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Client> getAll() {
        List<Client> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                Client client = objectMapper.readValue(scanner.nextLine(), Client.class);
                result.add(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void update(Client clientToUpdate) {
        List<Client> clientsList = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                clientsList.add(objectMapper.readValue(scanner.nextLine(), Client.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < clientsList.size(); i++) {
            Client oldClient = clientsList.get(i);
            if (oldClient.getId().equals(clientToUpdate.getId())) {
                clientsList.set(i, clientToUpdate);
                break;
            }
        }
        try (FileWriter writer = new FileWriter(file, false)) {
            for (Client client : clientsList) {
                String clientInfo = objectMapper.writeValueAsString(client);
                writer.append(String.format("%s%n", clientInfo));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
