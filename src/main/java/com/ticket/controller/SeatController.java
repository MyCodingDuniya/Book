package com.ticket.controller;

import com.ticket.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/save")
public class SeatController {
    int x=10;
    String s = "rahul";
    @Autowired
    private SeatService seatService;
    @PostMapping
    public String saveInitialSlot(@RequestParam("seatNumber")  int totalSeat){
    seatService.saveInitialSlot(totalSeat);
    return "seats are added";
    }
    @PostMapping("/reserve")
    public ResponseEntity<String> reserveSeat(@RequestParam String seatNumber) {
        boolean success = seatService.reserveSeat(seatNumber);
        if (success) {
            return ResponseEntity.ok("Seat reserved successfully.");
        } else {
            return ResponseEntity.badRequest().body("Seat is unavailable or already reserved.");
        }
    }
}
