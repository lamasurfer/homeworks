package org.example.task2.repository;


import org.example.task2.entity.client.Client;

import java.util.List;

public interface ClientRepository {

    void add(Client client);

    Client getById(String id);

    List<Client> getAll();

    void update(Client client);

}
