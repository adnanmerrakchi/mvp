package com.client.crudmvp.application.command;

public record AddressCommand(
        String street,
        String number,
        String additionalInfo,
        String postalCode,
        String municipality,
        String district
) {}
