package com.client.crudmvp.domain.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    private Address addr() {
        return new Address(
                "Avenue Louise",
                "12B",
                "3rd floor",
                "1050",
                "Ixelles",
                "Brussels"
        );
    }


    @Test
    void testCreateNew_happyPath() {
        String name = "Adnan MERRAKCHI";
        LocalDate dateOfBirth = LocalDate.of(1992,12,14);
        String taxNumber = "123456789";
        List<Address> addresses = List.of(addr());


        Client client = Client.createNew(name,
                                                dateOfBirth,
                                                taxNumber,
                                                addresses);
        assertNotNull(client);
        assertNotNull(client.getId());
        assertEquals("Adnan MERRAKCHI", client.getName());
        assertEquals(dateOfBirth, client.getDateOfBirth());
        assertEquals(taxNumber, client.getTaxNumber());
        assertEquals(addresses, client.getAddresses());
    }

    @Test
    void testCreateNew_emoptyAddressList_throwsException() {
        String name = "Adnan MERRAKCHI";
        LocalDate dateOfBirth = LocalDate.of(1992,12,14);
        String taxNumber = "123456789";
        List<Address> addresses = List.of();

        assertThrows(IllegalArgumentException.class, ()->
            Client.createNew(name,
                                    dateOfBirth,
                                    taxNumber,
                                    addresses),"Should throw when there are no addresses");
    }

    @Test
    void testCreateNew_ageUnder18_throwsException() {
        String name = "Adnan MERRAKCHI";
        LocalDate dateOfBirth = LocalDate.of(2020,12,14);
        String taxNumber = "123456789";
        List<Address> addresses = List.of();

        assertThrows(IllegalArgumentException.class, ()->
                Client.createNew(name,
                        dateOfBirth,
                        taxNumber,
                        addresses),"Should throw when client is under 18");
    }

    @Test
    void testRebuild_happyPath() {
        UUID id = UUID.randomUUID();
        String name = "Adnan MERRAKCHI";
        LocalDate dateOfBirth = LocalDate.of(1992,12,14);
        String taxNumber = "123456789";
        List<Address> addresses = List.of(addr());


        Client rebuiltClient = Client.rebuild(
                id,
                name,
                dateOfBirth,
                taxNumber,
                addresses);
        assertNotNull(rebuiltClient);
        assertEquals(id, rebuiltClient.getId());
        assertEquals(name, rebuiltClient.getName());
        assertEquals(dateOfBirth, rebuiltClient.getDateOfBirth());
        assertEquals(taxNumber, rebuiltClient.getTaxNumber());
        assertEquals(addresses, rebuiltClient.getAddresses());
    }

    @Test
    void testRebuild_emoptyAddressList_throwsException() {
        UUID id = UUID.randomUUID();
        String name = "Adnan MERRAKCHI";
        LocalDate dateOfBirth = LocalDate.of(1992,12,14);
        String taxNumber = "123456789";
        List<Address> addresses = List.of();

        assertThrows(IllegalArgumentException.class, ()->
                Client.rebuild(id,
                        name,
                        dateOfBirth,
                        taxNumber,
                        addresses),"Should throw when there are no addresses");
    }

    @Test
    void testRebuild_ageUnder18_throwsException() {
        UUID id = UUID.randomUUID();
        String name = "Adnan MERRAKCHI";
        LocalDate dateOfBirth = LocalDate.of(2020,12,14);
        String taxNumber = "123456789";
        List<Address> addresses = List.of();

        assertThrows(IllegalArgumentException.class, ()->
                Client.rebuild(id,
                        name,
                        dateOfBirth,
                        taxNumber,
                        addresses),"Should throw when client is under 18");
    }

}