package com.client.crudmvp.domain.model;

import java.util.Objects;

public record Address(
        String street,
        String number,
        String additionalInfo,
        String postalCode,
        String municipality,
        String district
) {
    public Address {
        Objects.requireNonNull(street, "street");
        Objects.requireNonNull(number, "number");
        Objects.requireNonNull(postalCode, "postalCode");
        Objects.requireNonNull(municipality, "municipality");
        Objects.requireNonNull(district, "district");
    }
}