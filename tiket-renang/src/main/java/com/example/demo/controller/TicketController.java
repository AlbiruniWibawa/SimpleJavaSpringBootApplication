package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.TicketRequestDTO;
import com.example.demo.dto.response.MessageResponse;
import com.example.demo.dto.response.TicketResponseDTO;
import com.example.demo.services.TicketService;

import lombok.RequiredArgsConstructor;

@RestController
@ControllerAdvice
@RequiredArgsConstructor
@RequestMapping("/api")
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/tickets")
    public List<TicketResponseDTO> getAllTickets() {
        return ticketService.findAllTickets();
    }
    
    @PostMapping("/ticket")
    public ResponseEntity<MessageResponse> createTickets(@RequestBody TicketRequestDTO request) {        
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.saveTicket(request));
    }
    
}
