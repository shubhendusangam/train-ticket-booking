package com.ticketbooking.trainticketbooking.service;

import com.ticketbooking.trainticketbooking.entity.Ticket;
import com.ticketbooking.trainticketbooking.entity.User;
import com.ticketbooking.trainticketbooking.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserService userService;

    /**
     *
     * @param from
     * @param to
     * @param price
     * @param section
     * @param user
     * @return Ticket
     */
    public Ticket purchaseTicket(String from, String to, Double price, String section, User user) {
        Ticket ticket = new Ticket();
        ticket.setFromLocation(from);
        ticket.setToLocation(to);
        ticket.setPrice(price);
        ticket.setSection(section);
        ticket.setUser(userService.saveUser(user));
        return ticketRepository.save(ticket);
    }

    /**
     *
     * @param ticketId
     * @return Ticket
     */
    public Ticket getTicketById(Long ticketId) {
        return ticketRepository.getTicketById(ticketId);
    }

    /**
     *
     * @param section
     * @return List<Ticket></>
     */
    public List<Ticket> getTicketsBySection(String section) {
        return ticketRepository.findAll().stream()
                .filter(ticket -> ticket.getSection().equals(section))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param ticketId
     * @param newSection
     * @return Ticket
     */
    public Ticket modifyTicket(Long ticketId, String newSection) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> new RuntimeException("Ticket not found"));
        ticket.setSection(newSection);
        return ticketRepository.save(ticket);
    }

    /**
     *
     * @param ticketId
     */
    public void deleteTicket(Long ticketId) {
        ticketRepository.deleteById(ticketId);
    }

}
