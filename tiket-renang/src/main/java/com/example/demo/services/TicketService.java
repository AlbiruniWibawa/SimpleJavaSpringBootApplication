package com.example.demo.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.TicketRequestDTO;
import com.example.demo.dto.response.MessageResponse;
import com.example.demo.dto.response.TicketResponseDTO;
import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketService {
    
    private final TicketRepository ticketRepository;

    public List<TicketResponseDTO> findAllTickets() {

        List<TicketResponseDTO> response = ticketRepository.findAll().stream().map(t -> new TicketResponseDTO(t)).toList();

        return response;
    }

    public MessageResponse saveTicket(TicketRequestDTO request) {

        Ticket ticket = new Ticket();
        ticket.setName(request.getName());
        ticket.setTicketDate(request.getTicketDate());

        ticketRepository.save(ticket);

        return new MessageResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase(), "Ticket saved successfully");
    }

}
