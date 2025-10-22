package com.client.crudmvp.adapter.web.response;

import java.time.LocalDate;

import java.util.UUID;

public record ClientResponse(
        UUID id,
        String name,
        LocalDate dateOfBirth,
        String taxNumber
) {}
