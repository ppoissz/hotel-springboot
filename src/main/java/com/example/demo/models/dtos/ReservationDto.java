package com.example.demo.models.dtos;

import com.example.demo.models.entities.Reservation;

import java.time.LocalDate;

public class ReservationDto {

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

    public ReservationDto(Integer id, Integer roomId, Integer clientId, LocalDate checkIn, LocalDate checkOut) {
        this.id = id;
        this.roomId = roomId;
        this.clientId = clientId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public static ReservationDto fromEntity(Reservation reservation) {
        return new ReservationDto(
                reservation.getId(),
                reservation.getRoomId(),
                reservation.getClientId(),
                reservation.getCheckIn(),
                reservation.getCheckOut()
        );
    }
}
