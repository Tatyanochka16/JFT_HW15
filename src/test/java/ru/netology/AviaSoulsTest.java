package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;


public class AviaSoulsTest {
    @Test
    public void shouldSortArrays() {
        Ticket ticket1 = new Ticket("Tokio", "Paris", 500, 17, 20);
        Ticket ticket2 = new Ticket("Tokio", "Paris", 500, 15, 17);
        Ticket ticket3 = new Ticket("Tokio", "Paris", 600, 12, 21);

        AviaSouls flight = new AviaSouls();

        flight.add(ticket1);
        flight.add(ticket2);
        flight.add(ticket3);
        Arrays.sort(flight.findAll());

        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = flight.findAll();
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldSortSearch() {
        Ticket ticket1 = new Ticket("Tokio", "Paris", 550, 17, 20);
        Ticket ticket2 = new Ticket("Tokio", "Paris", 500, 15, 17);
        Ticket ticket3 = new Ticket("Tokio", "Magadan", 600, 12, 21);
        Ticket ticket4 = new Ticket("Nagasaki", "Paris", 500, 15, 17);
        AviaSouls flight = new AviaSouls();

        flight.add(ticket1);
        flight.add(ticket2);
        flight.add(ticket3);
        flight.add(ticket4);


        Ticket[] expected = {ticket2, ticket1};
        Ticket[] actual = flight.search("Tokio", "Paris");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortComparator() {
        Ticket ticket1 = new Ticket("Tokio", "Paris", 550, 17, 20);
        Ticket ticket2 = new Ticket("Tokio", "Paris", 500, 15, 17);
        Ticket ticket3 = new Ticket("Tokio", "Paris", 600, 12, 21);

        AviaSouls flight = new AviaSouls();
        TicketTimeComparator flightTimeComparator = new TicketTimeComparator();
        flight.add(ticket1);
        flight.add(ticket2);
        flight.add(ticket3);
        Arrays.sort(flight.findAll(), flightTimeComparator);

        Ticket[] expected = {ticket2, ticket1, ticket3};
        Ticket[] actual = flight.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortAndComparator() {
        Ticket ticket1 = new Ticket("Tokio", "Paris", 550, 17, 20);
        Ticket ticket2 = new Ticket("Tokio", "Paris", 500, 15, 17);
        Ticket ticket3 = new Ticket("Tokio", "Paris", 600, 12, 21);
        Ticket ticket4 = new Ticket("Nagasaki", "Paris", 500, 15, 17);
        Ticket ticket5 = new Ticket("Tokio", "Magadan", 600, 12, 21);
        AviaSouls flight = new AviaSouls();
        TicketTimeComparator flightTimeComparator = new TicketTimeComparator();
        flight.add(ticket1);
        flight.add(ticket2);
        flight.add(ticket3);
        flight.add(ticket4);
        flight.add(ticket5);

        Ticket[] expected = {ticket2, ticket1, ticket3};
        Ticket[] actual = flight.searchAndSortBy("Tokio", "Paris", flightTimeComparator);
        Assertions.assertArrayEquals(expected, actual);

    }
}