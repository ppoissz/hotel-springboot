package com.example.demo.models.entities;

import com.example.demo.models.dtos.RoomDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private Integer id;
    private String roomNumber;
    private String type;
    private Double pricePerNight;
    private LocalDate createdAt;

    public Integer getId() {
        return id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public Room(Integer id, String roomNumber, String type, Double pricePerNight) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.createdAt = LocalDate.now();
    }

    public static Room fromDto(RoomDto roomDto) {
        return new Room(
                roomDto.getId(),
                roomDto.getRoomNumber(),
                roomDto.getType(),
                roomDto.getPricePerNight()
        );
    }

    public Room() {
    }
}
