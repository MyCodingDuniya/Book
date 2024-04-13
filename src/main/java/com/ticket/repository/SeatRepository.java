package com.ticket.repository;

import com.ticket.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat,Long> {
    Seat findBySeatNumber(String seatNumber);
}
