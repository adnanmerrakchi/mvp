package com.client.crudmvp.adapter.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

public record ClientRequest(
        @NotBlank String name,
        @NotNull LocalDate dateOfBirth,
        @NotBlank String taxNumber,
        @Size(min = 1) List<AddressRequest>addresses
) {
    public record AddressRequest(
            @NotBlank String street,
            @NotBlank String number,
            @NotBlank String additionalInfo,
            @NotBlank String postalCode,
            @NotBlank String municipality,
            @NotBlank String district
    ){}
}