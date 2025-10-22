package com.client.crudmvp.adapter.web.mapper;

import com.client.crudmvp.adapter.web.response.ClientResponse;
import com.client.crudmvp.application.dto.ClientOutput;
import org.mapstruct.Mapper;

@Mapper( componentModel = "spring")
public interface ClientWebMapper {

    ClientResponse toResponse(ClientOutput output);

}
