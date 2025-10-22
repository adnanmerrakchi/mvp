package com.client.crudmvp.adapter.web;

import com.client.crudmvp.adapter.web.mapper.ClientWebMapper;
import com.client.crudmvp.adapter.web.request.ClientRequest;
import com.client.crudmvp.adapter.web.response.ClientResponse;
import com.client.crudmvp.application.command.AddressCommand;
import com.client.crudmvp.application.command.ClientCommand;
import com.client.crudmvp.application.usecase.CreateClientUseCase;
import com.client.crudmvp.domain.repository.ClientRepositoryPort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final CreateClientUseCase createClientUseCase;
    private final ClientWebMapper clientMapper;

    public ClientController(ClientRepositoryPort clientRepositoryPort, ClientWebMapper clientMapper) {
        this.createClientUseCase = new CreateClientUseCase(clientRepositoryPort);
        this.clientMapper = clientMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponse create(@Valid @RequestBody ClientRequest request){
        var clientCommand = new ClientCommand(  request.name(),
            request.dateOfBirth(),
            request.taxNumber(),
            request.addresses()
                    .stream()
                    .map(a -> new AddressCommand(   a.street(), a.number(),
                            a.additionalInfo(),a.postalCode(),a.municipality(),
                            a.district()))
                    .toList());
        return clientMapper.toResponse(createClientUseCase.addClient(clientCommand));
    }
}
