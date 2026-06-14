package com.example.demo.controllers;

import com.example.demo.models.dtos.RoomDto;
import com.example.demo.services.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RoomDto> save(@RequestBody RoomDto roomDto) {
        return ResponseEntity.ok(service.save(roomDto));
    }

    @GetMapping
    public ResponseEntity<List<RoomDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<RoomDto> edit(@RequestBody RoomDto roomDto) {
        return ResponseEntity.ok(service.edit(roomDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
