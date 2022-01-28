package org.example.task2.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.task2.entity.vet.Vet;
import org.example.task2.entity.vet.VetSpecialty;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaffRepositoryImpl implements StaffRepository {

    private final File file;
    private final ObjectMapper objectMapper;

    public StaffRepositoryImpl(File file, ObjectMapper objectMapper) {
        this.file = file;
        this.objectMapper = objectMapper;
    }

    @Override
    public void add(Vet vet) {
        try (FileWriter writer = new FileWriter(file, true)) {
            String vetString = objectMapper.writeValueAsString(vet);
            writer.append(String.format("%s%n", vetString));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Vet getById(String id) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                Vet vet = objectMapper.readValue(scanner.nextLine(), Vet.class);
                if (vet.getId().equals(id)) {
                    return vet;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Vet> getBySpecialty(VetSpecialty specialty) {
        List<Vet> staff = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                Vet vet = objectMapper.readValue(scanner.nextLine(), Vet.class);
                if (vet.getSpecialty().equals(specialty)) {
                    staff.add(vet);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return staff;
    }

    @Override
    public List<Vet> getAll() {
        List<Vet> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                Vet vet = objectMapper.readValue(scanner.nextLine(), Vet.class);
                result.add(vet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
