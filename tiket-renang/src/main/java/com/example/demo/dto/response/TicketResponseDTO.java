package com.example.demo.dto.response;

import java.sql.Date;

import com.example.demo.model.Ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponseDTO {
    
    private String name;
    private Date ticketDate;

    public TicketResponseDTO(Ticket ticket) {
        this.name = ticket.getName();
        this.ticketDate = ticket.getTicketDate();
    }

}
