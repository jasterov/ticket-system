package cz.jasterov.ticketsystem.service;

import cz.jasterov.ticketsystem.dao.Repository;
import cz.jasterov.ticketsystem.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TicketSystemServiceImpl implements TicketSystemService {

    private Repository ticketRepository;

    @Autowired
    public TicketSystemServiceImpl(Repository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket generateNewTicket() {return ticketRepository.generateNewTicket(); }

    @Override
    public Ticket deleteFirstTicket() {
        return ticketRepository.deleteFirstTicket();
    }

    @Override
    public Ticket showFirstTicket() {
        return ticketRepository.showFirstTicket();
    }

    @Override
    public List<Ticket> getListOfTickets() {
        return ticketRepository.getListOfTickets();
    }


}
