package com.client.crudmvp.adapter.persistence.repository;

import com.client.crudmvp.adapter.persistence.entity.ClientEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClientJpaRepository extends JpaRepository<ClientEntity, UUID> {

    default List<ClientEntity> findPage(int page, int size) {
        return findAll(Pageable.ofSize(size).withPage(page)).getContent();
    }
}
