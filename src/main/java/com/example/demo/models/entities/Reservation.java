package com.example.demo.models.entities;

import com.example.demo.models.dtos.ReservationDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer roomId;
    private Integer clientId;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Integer getId() {
        return id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public Reservation(Integer id, Integer roomId, Integer clientId, LocalDate checkIn, LocalDate checkOut) {
        this.id = id;
        this.roomId = roomId;
        this.clientId = clientId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public static Reservation fromDto(ReservationDto dto) {
        return new Reservation(
                dto.getId(),
                dto.getRoomId(),
                dto.getClientId(),
                dto.getCheckIn(),
                dto.getCheckOut()
        );
    }

    public Reservation() {
    }
}
