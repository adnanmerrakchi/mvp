package com.client.crudmvp.adapter.persistence.mapper;

import com.client.crudmvp.adapter.persistence.entity.AddressEntity;
import com.client.crudmvp.adapter.persistence.entity.ClientEntity;
import com.client.crudmvp.domain.model.Address;
import com.client.crudmvp.domain.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ObjectFactory;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "addresses", source = "addresses", qualifiedByName = "toAddressEntity" )
    ClientEntity toEntity(Client client);

    @Mapping(target = "addresses", source = "addresses", qualifiedByName = "toAddressModel" )
    Client toModel(ClientEntity clientEntity);

    @Named("toAddressEntity")
    default List<AddressEntity> toAddressEntity(List<Address> addresses) {
        return addresses.stream()
                        .map(adrr -> new AddressEntity( adrr.street(), adrr.number(),
                                                                adrr.additionalInfo(), adrr.postalCode(),
                                                                adrr.municipality(), adrr.district()))
                        .toList();
    }

    @Named("toAddressModel")
    default List<Address> toAddressModel(List<AddressEntity> addresses) {
        return addresses
                .stream()
                .map( addr ->  new Address( addr.getStreet(),addr.getStreet(),
                                                        addr.getAdditionalInfo(), addr.getPostalCode(),
                                                        addr.getMunicipality(), addr.getDistrict()))
                .toList();
    }

    @ObjectFactory
    default Client createClientEntity(ClientEntity clientEntity) {
        return Client.rebuild(  clientEntity.getId(),clientEntity.getName(),
                                clientEntity.getDateOfBirth(), clientEntity.getTaxNumber(),
                                toAddressModel( clientEntity.getAddresses()));
    }

}
