package com.client.crudmvp.domain.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Client {

    private final UUID id;
    private String name;
    private LocalDate dateOfBirth;
    private String taxNumber;
    private final List<Address> addresses = new ArrayList<>();

    private Client( UUID id,
                    String name,
                    LocalDate dateOfBirth,
                    String taxNumber,
                    Collection<Address> addresses) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.name = Objects.requireNonNull(name, "name");
        this.dateOfBirth = Objects.requireNonNull(dateOfBirth, "dateOfBirth");
        this.taxNumber = Objects.requireNonNull(taxNumber, "taxNumber");
        if (addresses != null) this.addresses.addAll(addresses);
        validate();
    }

    public static Client createNew(String name, LocalDate dateOfBirth, String taxNumber, Collection<Address> addresses) {
        return new Client(null, name, dateOfBirth, taxNumber, addresses);
    }

    public static Client rebuild(UUID id, String name, LocalDate dateOfBirth, String taxNumber, Collection<Address> addresses) {
        return new Client(id, name, dateOfBirth, taxNumber, addresses);
    }

    private void validate() {
        if (Period.between(this.dateOfBirth, LocalDate.now()).getYears() < 18) {
            throw new IllegalArgumentException("Client must be 18+ years old");
        }
        if (this.addresses.isEmpty()) {
            throw new IllegalArgumentException("Client must have at least one address");
        }
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public List<Address> getAddresses() {
        return addresses;
    }
}
