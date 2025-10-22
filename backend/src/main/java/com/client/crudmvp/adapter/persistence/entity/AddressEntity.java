package com.client.crudmvp.adapter.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "address")
public class AddressEntity {

    @Id
    private UUID id;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private String additionalInfo;
    @Column(nullable = false)
    private String postalCode;
    @Column(nullable = false)
    private String municipality;
    @Column(nullable = false)
    private String district;

    public AddressEntity() {
    }

    public AddressEntity( String street, String number, String additionalInfo, String postalCode, String municipality, String district) {
        this.id = UUID.randomUUID();
        this.street = street;
        this.number = number;
        this.additionalInfo = additionalInfo;
        this.postalCode = postalCode;
        this.municipality = municipality;
        this.district = district;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
