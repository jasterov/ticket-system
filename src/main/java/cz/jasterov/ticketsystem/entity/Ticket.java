package cz.jasterov.ticketsystem.entity;



public class Ticket {

    private Long ticketNbr;
    private String emissionTime;


    public Ticket(Long ticketNbr, String emissionTime) {
        this.ticketNbr = ticketNbr;
        this.emissionTime = emissionTime;
    }

    public Long getTicketNbr() {
        return ticketNbr;
    }

    public String getEmissionTime() {
        return emissionTime;
    }


}
