package com.example.demo.controllers;

import com.example.demo.models.dtos.ReservationDto;
import com.example.demo.services.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ReservationDto> save(@RequestBody ReservationDto reservationDto) {
        return ResponseEntity.ok(service.save(reservationDto));
    }

    @GetMapping
    public ResponseEntity<List<ReservationDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<ReservationDto>> findByClientId(@PathVariable Integer clientId) {
        return ResponseEntity.ok(service.findByClientId(clientId));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
