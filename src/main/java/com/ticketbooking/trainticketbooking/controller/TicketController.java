/*
 * create by : Shubhendu Sangam
 * */
package com.ticketbooking.trainticketbooking.controller;

import com.ticketbooking.trainticketbooking.dto.SeatChangeRequest;
import com.ticketbooking.trainticketbooking.dto.TicketRequest;
import com.ticketbooking.trainticketbooking.entity.Ticket;
import com.ticketbooking.trainticketbooking.entity.User;
import com.ticketbooking.trainticketbooking.exceptionhandler.ResourceNotFoundException;
import com.ticketbooking.trainticketbooking.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/purchase-ticket")
    public ResponseEntity<Ticket> purchaseTicket(@RequestBody TicketRequest request) {
        User user = new User(request.getFirstName(), request.getLastName(), request.getEmail());
        Ticket ticket = ticketService.purchaseTicket(request.getFromLocation(), request.getToLocation(), request.getPrice(), request.getSection(), user);
        return ResponseEntity.ok(ticket);
    }

    @GetMapping("/receipt/{ticketId}")
    public ResponseEntity<Ticket> getReceipt(@PathVariable Long ticketId) {
        Ticket ticket = ticketService.getTicketById(ticketId);
        if (ticket == null)
            throw new ResourceNotFoundException("Ticket with id " + ticketId + " not found");
        return ResponseEntity.ok(ticket);
    }

    @GetMapping("/user-by-section/{section}")
    public ResponseEntity<List<Ticket>> getUsersBySection(@PathVariable String section) {
        List<Ticket> tickets = ticketService.getTicketsBySection(section);
        if (tickets.isEmpty())
            throw new ResourceNotFoundException("No tickets found for section " + section);
        return ResponseEntity.ok(tickets);
    }

    @DeleteMapping("/remove-user/{ticketId}")
    public ResponseEntity<?> removeUser(@PathVariable Long ticketId) {
        Ticket ticket = ticketService.getTicketById(ticketId);
        if (ticket == null)
            throw new ResourceNotFoundException("Ticket not found");

        ticketService.deleteTicket(ticketId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/modify-seat/{ticketId}")
    public ResponseEntity<Ticket> modifySeat(@PathVariable Long ticketId, @RequestBody SeatChangeRequest request) {
        Ticket ticket = ticketService.getTicketById(ticketId);
        if (ticket == null)
            throw new ResourceNotFoundException("Ticket not found");
        ticket = ticketService.modifyTicket(ticketId, request.getNewSection());
        return ResponseEntity.ok(ticket);
    }
}

