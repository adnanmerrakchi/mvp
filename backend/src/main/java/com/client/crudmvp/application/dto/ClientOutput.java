package com.client.crudmvp.application.dto;

import java.time.LocalDate;
import java.util.UUID;

public record ClientOutput(
        UUID id,
        String name,
        LocalDate dateOfBirth,
        String taxNumber
) {
}
