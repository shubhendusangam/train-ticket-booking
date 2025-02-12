/*
 * create by : Shubhendu Sangam
 * */

package com.ticketbooking.trainticketbooking.service;

import com.ticketbooking.trainticketbooking.TrainTicketBookingApplication;
import com.ticketbooking.trainticketbooking.entity.Ticket;
import com.ticketbooking.trainticketbooking.entity.User;
import com.ticketbooking.trainticketbooking.repository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = TrainTicketBookingApplication.class)
public class TicketServiceTest {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketRepository ticketRepository;


    @Test
    public void testPurchaseTicket() {
        Ticket expectedTicket = createSingleTicket();
        Ticket result = ticketService.purchaseTicket(expectedTicket.getFromLocation(), expectedTicket.getToLocation(), expectedTicket.getPrice(), expectedTicket.getSection(), expectedTicket.getUser());

        assertNotNull(result);
        assertEquals("London", result.getFromLocation());
        assertEquals("France", result.getToLocation());
        assertEquals(20.0, result.getPrice());
        assertEquals("A", result.getSection());
        assertEquals(expectedTicket.getUser(), result.getUser());
    }

    private Ticket createSingleTicket() {
        User user = new User("Rambo", "Test", "rambo.test@tempmail.com");
        Ticket ticket = new Ticket();
        ticket.setFromLocation("London");
        ticket.setToLocation("France");
        ticket.setPrice(20.0);
        ticket.setSection("A");
        ticket.setUser(user);
        return ticket;
    }

    @Test
    public void testGetTicketsBySection() {
        List<Ticket> tickets = Arrays.asList(
                new Ticket("Bangalore", "Hyderabad", 200.0, "A", new User("rambo", "test", "rambo.test@tempmail.com")),
                new Ticket("London", "France", 225.0, "A", new User("dare", "devil", "dare.devil@tempmail.com")),
                new Ticket("Bhubaneswar", "Hyderabad", 200.0, "B", new User("rama", "test", "rama.test@tempmail.com")),
                new Ticket("Puri", "Bangalore", 225.0, "B", new User("demo", "devil", "demo.devil@tempmail.com"))
        );

        ticketRepository.saveAll(tickets);

        List<Ticket> resultByA = ticketService.getTicketsBySection("A");
        List<Ticket> resultByB = ticketService.getTicketsBySection("B");

        assertEquals(2, resultByA.size());
        assertEquals(2, resultByB.size());
    }

    @Test
    public void testModifyTicket() {
        Ticket expectedTicket = createSingleTicket();
        Ticket result = ticketService.purchaseTicket(expectedTicket.getFromLocation(), expectedTicket.getToLocation(), expectedTicket.getPrice(), expectedTicket.getSection(), expectedTicket.getUser());
        assertNotNull(result);

        result = ticketService.modifyTicket(result.getId(), "B");

        assertEquals("B", result.getSection());
    }

    @Test
    public void testDeleteTicket() {
        Ticket expectedTicket = createSingleTicket();
        Ticket result = ticketService.purchaseTicket(expectedTicket.getFromLocation(), expectedTicket.getToLocation(), expectedTicket.getPrice(), expectedTicket.getSection(), expectedTicket.getUser());
        assertNotNull(result);
        ticketService.deleteTicket(result.getId());
    }
}