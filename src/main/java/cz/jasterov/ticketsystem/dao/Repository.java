package cz.jasterov.ticketsystem.dao;

import cz.jasterov.ticketsystem.entity.Ticket;

import java.util.List;

public interface Repository {

    public Ticket generateNewTicket();
    public Ticket showFirstTicket();
    public Ticket deleteFirstTicket();
    public List<Ticket> getListOfTickets();
}
