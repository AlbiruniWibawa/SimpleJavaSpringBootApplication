package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Reservation;

@Repository
public class ReservationRepository {
    
    List<Reservation> reservationList = new ArrayList<>();

    public List<Reservation> findAll() {
        return reservationList;
    }

    public Reservation save(Reservation reservation) {
        reservationList.add(reservation);

        return reservation;
    }

    public Integer countByDate(String date) {
        return reservationList.stream().filter(r -> r.getDate().equalsIgnoreCase(date)).toList().size();
    }

}
