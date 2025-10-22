package com.client.crudmvp.adapter.web.response;

import java.util.UUID;

public record ClientResponse(
        UUID id,
        String name,
        String taxNumber
) {}
