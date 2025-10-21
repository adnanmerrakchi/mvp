package com.client.crudmvp.application.command;

import java.time.LocalDate;
import java.util.List;

public record ClientCommand(
        String name,
        LocalDate dateOfBirth,
        String taxNumber,
        List<AddressCommand> addresses
) {}
