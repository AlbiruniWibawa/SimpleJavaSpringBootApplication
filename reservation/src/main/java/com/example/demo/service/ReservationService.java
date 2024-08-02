package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ReservationRequest;
import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationService {
    
    private final ReservationRepository reservationRepository;

    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    public Reservation addReservation(ReservationRequest request) throws Exception {
        String reservationDate = request.getDate();

       if (reservationDate.equalsIgnoreCase("rabu") || reservationDate.equalsIgnoreCase("jumat")) {
            throw new Exception("Libur");
        }
        long reservationCount = reservationRepository.countByDate(reservationDate);
        
        if (reservationCount >= 2) {
            throw new Exception("Reservations are full for this date");
        }
      
        Reservation reservation = new Reservation();
        reservation.setName(request.getName());
        reservation.setDate(reservationDate);
        
        return reservationRepository.save(reservation);
    }
}
