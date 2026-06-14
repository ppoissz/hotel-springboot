package com.example.demo.controllers;

import com.example.demo.models.dtos.ClientDto;
import com.example.demo.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClientDto> save(@RequestBody ClientDto clientDto) {
        return ResponseEntity.ok(service.save(clientDto));
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<ClientDto> edit(@RequestBody ClientDto clientDto) {
        return ResponseEntity.ok(service.edit(clientDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
