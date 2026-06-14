package com.example.demo.services;

import com.example.demo.models.dtos.ReservationDto;
import com.example.demo.models.entities.Reservation;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.ReservationRepository;
import com.example.demo.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private final ReservationRepository repository;
    private final RoomRepository roomRepository;
    private final ClientRepository clientRepository;

    public ReservationService(ReservationRepository repository, RoomRepository roomRepository, ClientRepository clientRepository) {
        this.repository = repository;
        this.roomRepository = roomRepository;
        this.clientRepository = clientRepository;
    }

    public ReservationDto save(ReservationDto dto) {
        if (!roomRepository.existsById(dto.getRoomId())) {
            throw new NoSuchElementException("Room not found");
        }
        if (!clientRepository.existsById(dto.getClientId())) {
            throw new NoSuchElementException("Client not found");
        }
        if (dto.getCheckOut().isBefore(dto.getCheckIn()) || dto.getCheckOut().isEqual(dto.getCheckIn())) {
            throw new IllegalArgumentException("Check-out date must be after check-in date");
        }
        boolean conflict = repository.findByRoomId(dto.getRoomId()).stream().anyMatch(r ->
                !dto.getCheckIn().isAfter(r.getCheckOut()) && !dto.getCheckOut().isBefore(r.getCheckIn())
        );
        if (conflict) {
            throw new IllegalArgumentException("Room is already reserved for the selected dates");
        }
        return ReservationDto.fromEntity(repository.save(Reservation.fromDto(dto)));
    }

    public List<ReservationDto> findAll() {
        return repository.findAll().stream().map(ReservationDto::fromEntity).collect(Collectors.toList());
    }

    public ReservationDto findById(Integer id) {
        return ReservationDto.fromEntity(repository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    public List<ReservationDto> findByClientId(Integer clientId) {
        return repository.findByClientId(clientId).stream().map(ReservationDto::fromEntity).collect(Collectors.toList());
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
