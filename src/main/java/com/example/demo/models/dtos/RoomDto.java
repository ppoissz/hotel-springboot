package com.example.demo.models.dtos;

import com.example.demo.models.entities.Room;

public class RoomDto {
    private Integer id;
    private String roomNumber;
    private String type;
    private Double pricePerNight;

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

    public RoomDto(Integer id, String roomNumber, String type, Double pricePerNight) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
    }

    public static RoomDto fromEntity(Room room) {
        return new RoomDto(
                room.getId(),
                room.getRoomNumber(),
                room.getType(),
                room.getPricePerNight()
        );
    }
}
