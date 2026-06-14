package com.example.demo.repositories;

import com.example.demo.models.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    List<Reservation> findByRoomId(Integer roomId);

    List<Reservation> findByClientId(Integer clientId);
}
