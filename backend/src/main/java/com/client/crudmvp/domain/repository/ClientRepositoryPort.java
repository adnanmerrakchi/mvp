package com.client.crudmvp.domain.repository;

import com.client.crudmvp.domain.model.Client;

import java.util.List;

public interface ClientRepositoryPort {

    Client save(Client client);
    List<Client> findAll(int page, int size);
}
