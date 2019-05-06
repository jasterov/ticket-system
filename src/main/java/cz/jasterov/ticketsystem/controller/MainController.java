package cz.jasterov.ticketsystem.controller;


import cz.jasterov.ticketsystem.entity.Ticket;
import cz.jasterov.ticketsystem.service.TicketSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    private final TicketSystemService ticketSystemService;

    @Autowired
    public MainController(TicketSystemService ticketSystemService) {
        this.ticketSystemService = ticketSystemService;
    }

    /**
     * Generate new ticket
     */
    @PostMapping(value = {"/ticket/new"}, produces = "application/json")
    public String generateNewTicket() {
        Ticket ticket = ticketSystemService.generateNewTicket();
        return returnJson(ticket, ticketSystemService.getListOfTickets().size()-1, "generated");

    }

    /**
     * Return first ticket.
     */
    @GetMapping(value = {"/ticket/actual"}, produces = "application/json")
    public String showFirstTicket() {
        Ticket ticket = ticketSystemService.showFirstTicket();;
        return returnJson(ticket, 0, "called");
    }

    /**
     * Delete first ticket
     */
    @DeleteMapping(value = {"/ticket/delete"}, produces = "application/json")
    public String deleteFirstTicket() {
        Ticket ticket = ticketSystemService.deleteFirstTicket();
        return returnJson(ticket, 0,
                "deleted");
    }

    /**
     * Return correct form of json
     * @param ticket ticked modified
     * @param order order of ticket in list of all active tickets
     * @param status status describing action done with ticket
     *
     * @return json describing ticket and action done
     */
    private String returnJson(Ticket ticket, int order, String status){
        String pattern =
                "{ \"ticket_number\":\"%s\", \"time\":\"%s\", \"order\": \"%s\", \"status\":\"%s\"}";
        return String.format(pattern,  ticket.getTicketNbr(), ticket.getEmissionTime(),
                order, status);
    }
}
