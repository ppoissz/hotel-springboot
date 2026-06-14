package com.example.demo.models.dtos;

import com.example.demo.models.entities.Client;

public class ClientDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ClientDto(Integer id, String firstName, String lastName, String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public static ClientDto fromEntity(Client client) {
        return new ClientDto(
                client.getId(),
                client.getFirstName(),
                client.getLastName(),
                client.getEmail(),
                client.getPhoneNumber()
        );
    }
}
