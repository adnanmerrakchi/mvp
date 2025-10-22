package com.client.crudmvp.adapter.persistence.impl;


import com.client.crudmvp.adapter.persistence.mapper.ClientMapper;
import com.client.crudmvp.adapter.persistence.repository.ClientJpaRepository;
import com.client.crudmvp.domain.model.Client;
import com.client.crudmvp.domain.repository.ClientRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepositoryAdapter implements ClientRepositoryPort {

    private final ClientJpaRepository clientJpaRepository;
    private final ClientMapper clientMapper;

    public ClientRepositoryAdapter(ClientJpaRepository clientJpaRepository,
                                   ClientMapper clientMapper) {
        this.clientJpaRepository = clientJpaRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public Client save(Client client) {
        return clientMapper.toModel(clientJpaRepository.save(clientMapper.toEntity(client)));
    }

    @Override
    public List<Client> findAll(int page, int size) {
        return clientJpaRepository.findPage(page,size)
                                .stream().map(clientMapper::toModel)
                                .toList();
    }
}
