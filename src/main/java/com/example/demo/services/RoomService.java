package com.example.demo.services;

import com.example.demo.models.dtos.RoomDto;
import com.example.demo.models.entities.Room;
import com.example.demo.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class RoomService {

    private final RoomRepository repository;

    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    public RoomDto save(RoomDto roomDto) {
        return RoomDto.fromEntity(repository.save(Room.fromDto(roomDto)));
    }

    public List<RoomDto> findAll() {
        return repository.findAll().stream().map(room -> RoomDto.fromEntity(room)).collect(Collectors.toList());
    }

    public RoomDto findById(Integer id) {
        return RoomDto.fromEntity(repository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    public RoomDto edit(RoomDto roomDto) {
        return RoomDto.fromEntity(repository.save(Room.fromDto(roomDto)));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
