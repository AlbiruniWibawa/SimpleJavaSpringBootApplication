package com.example.demo.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Ticket;

@Repository
public class TicketRepository {

    private List<Ticket> tickets = new ArrayList<>();
    
    public List<Ticket> findAll() {

        if (tickets.isEmpty()) {
            Ticket ticket1 = new Ticket();
            ticket1.setName("Ticket 1");
            ticket1.setTicketDate(Date.valueOf(LocalDate.now().minusDays(1)));
            tickets.add(ticket1);

            Ticket ticket2 = new Ticket();
            ticket2.setName("Ticket 2");
            ticket2.setTicketDate(Date.valueOf(LocalDate.now()));
            tickets.add(ticket2);
        }

        return tickets;
    }

    public Ticket save(Ticket ticket) {
        tickets.add(ticket);
        return ticket;
    }

}
