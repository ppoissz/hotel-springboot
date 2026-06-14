package com.example.demo.services;

import com.example.demo.models.dtos.ClientDto;
import com.example.demo.models.entities.Client;
import com.example.demo.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public ClientDto save(ClientDto clientDto) {
        if (repository.findByEmail(clientDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Client with this email already exists");
        }
        return ClientDto.fromEntity(repository.save(Client.fromDto(clientDto)));
    }

    public List<ClientDto> findAll() {
        return repository.findAll().stream().map(ClientDto::fromEntity).collect(Collectors.toList());
    }

    public ClientDto findById(Integer id) {
        return ClientDto.fromEntity(repository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    public ClientDto edit(ClientDto clientDto) {
        return ClientDto.fromEntity(repository.save(Client.fromDto(clientDto)));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
