package cz.jasterov.ticketsystem.service;

import cz.jasterov.ticketsystem.entity.Ticket;

import java.util.List;

public interface TicketSystemService {

    public Ticket generateNewTicket();
    public Ticket showFirstTicket();
    public Ticket deleteFirstTicket();
    public List<Ticket> getListOfTickets();
}
