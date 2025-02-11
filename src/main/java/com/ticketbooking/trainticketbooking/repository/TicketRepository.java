package com.ticketbooking.trainticketbooking.repository;

import com.ticketbooking.trainticketbooking.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
