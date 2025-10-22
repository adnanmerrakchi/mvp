package com.client.crudmvp.application.usecase;

import com.client.crudmvp.application.command.ClientCommand;
import com.client.crudmvp.application.dto.ClientOutput;
import com.client.crudmvp.domain.model.Address;
import com.client.crudmvp.domain.model.Client;
import com.client.crudmvp.domain.repository.ClientRepositoryPort;

import java.util.List;

public class CreateClientUseCase {

    private final ClientRepositoryPort clientRepositoryPort;

    public CreateClientUseCase(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    public ClientOutput addClient(ClientCommand clientCommand){
        List<Address> addrs = clientCommand
                .addresses()
                .stream()
                .map(a -> new Address(  a.street(),
                                                        a.number(),
                                                        a.additionalInfo(),
                                                        a.postalCode(),
                                                        a.municipality(),
                                                        a.district()))
                .toList();

        Client client = Client.createNew(   clientCommand.name(),
                                            clientCommand.dateOfBirth(),
                                            clientCommand.taxNumber(),
                                            addrs);

        Client savedClient =  clientRepositoryPort.save(client);

        return new ClientOutput(savedClient.getId(), savedClient.getName(), savedClient.getTaxNumber());
    }


}
