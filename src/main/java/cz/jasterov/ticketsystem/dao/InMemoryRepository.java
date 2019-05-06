package cz.jasterov.ticketsystem.dao;

import cz.jasterov.ticketsystem.entity.Ticket;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryRepository implements Repository {

    private List<Ticket> listOfTickets;
    private Long ticketNbr;

    public InMemoryRepository() {
        this.listOfTickets = new ArrayList<>();
        this.ticketNbr = 0L;
    }

    @Override
    public List<Ticket> getListOfTickets() {
        return listOfTickets;
    }

    public Long getTicketNbr() {
        return ticketNbr;
    }

    public void setTicketNbr(Long ticketNbr) {
        this.ticketNbr = ticketNbr;
    }

    @Override
    public Ticket generateNewTicket(){
        Ticket newTicket = new Ticket(ticketNbr,
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        listOfTickets.add(newTicket);
        ticketNbr = ticketNbr + 1;
        return newTicket;
    }

    @Override
    public Ticket deleteFirstTicket(){
        if(listOfTickets.size() > 0){
        Ticket firstTicket = listOfTickets.get(0);
        listOfTickets.remove(firstTicket);
        return firstTicket;
        }
        return new Ticket (null, null);
    }

    @Override
    public Ticket showFirstTicket(){
        if(listOfTickets.size() > 0){
            Ticket firstTicket = listOfTickets.get(0);
            return firstTicket;
        }
        return new Ticket (null, null);
    }

}
