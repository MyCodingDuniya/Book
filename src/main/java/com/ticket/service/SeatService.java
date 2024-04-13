package com.ticket.service;

import com.ticket.entity.Seat;
import com.ticket.repository.SeatRepository;
import jakarta.persistence.OptimisticLockException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public void saveInitialSlot(int numSeats) {
        for (int i = 1; i <= numSeats; i++) {
            Seat seat = new Seat();
            seat.setSeatNumber("Seat-" + i); // Assign a seat number
            seat.setStatus("available");
            seatRepository.save(seat);
        }
    }
    @Transactional
    public boolean reserveSeat(String seatNumber) {
        Seat seat = seatRepository.findBySeatNumber(seatNumber);
        if (seat != null && seat.getStatus().equals("available")) {
            try {
                seat.setStatus("reserved");
                seatRepository.save(seat);
                return true;
            } catch (OptimisticLockException ex) {
                System.out.println(ex);
                return false;
            }
        }
        return false;
    }
}
