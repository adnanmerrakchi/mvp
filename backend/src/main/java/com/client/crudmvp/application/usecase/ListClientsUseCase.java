package com.client.crudmvp.application.usecase;

import com.client.crudmvp.application.dto.ClientOutput;
import com.client.crudmvp.domain.model.Client;
import com.client.crudmvp.domain.repository.ClientRepositoryPort;

import java.util.List;

public class ListClientsUseCase {

    private final ClientRepositoryPort clientRepositoryPort;

    public ListClientsUseCase(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    public List<ClientOutput> listClients(int page, int size){
        return clientRepositoryPort.findAll(page, size)
                .stream()
                .map(c -> new ClientOutput(c.getId(),c.getName(),c.getDateOfBirth(),c.getTaxNumber()))
                .toList();
    }


}
