Exercise

Create a small client CRUD system.

Each client must have:

    Name
    Date of birth
    Tax identification number
    List of addresses:
        Street  
        Number
        Additional info
        Postal code
        Municipality
        District



Functional Requirements

    The client must be over 18 years old.
    The client must have at least one registered address.
    On the client registration screen, it must be possible to add and remove addresses.
    Every address must be associated with a client.
    The address fields must be filled in according to the postal code, which must be integrated with the following API:
    https://geoapi.pt/docs/
    If the postal code is not found, the user must be notified, and the fields must be enabled for manual input.



Non-Functional Requirements:

Frontend:

    Angular 19

Backend:

    Java 17
    Spring Boot
    Maven
    In-memory H2 database
    Tests: unit and integration