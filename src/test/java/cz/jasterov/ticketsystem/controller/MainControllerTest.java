package cz.jasterov.ticketsystem.controller;

import cz.jasterov.ticketsystem.entity.Ticket;
import cz.jasterov.ticketsystem.service.TicketSystemService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class MainControllerTest {
    @InjectMocks
    private MainController mainController;

    @Mock
    private TicketSystemService ticketSystemService;

    @Mock
    private List<Ticket> listOfTickets;

    @Mock
    private Ticket newTicket;

    @Mock
    private Ticket deletedTicket;

    @Mock
    private Ticket firstTicket;


    String newTicketJson = "{ \"ticket_number\":\"2\", \"time\":\"2019-01-01 12:12\"," +
            " \"order\": \"1\", \"status\":\"generated\"}";

    String firstTicketJson = "{ \"ticket_number\":\"3\", \"time\":\"2019-01-01 12:13\"," +
            " \"order\": \"0\", \"status\":\"called\"}";

    String deletedTicketJson = "{ \"ticket_number\":\"4\", \"time\":\"2019-01-01 12:14\"," +
            " \"order\": \"0\", \"status\":\"deleted\"}";



    @Before
    public void setUp() {
        Mockito.when(ticketSystemService.generateNewTicket()).thenReturn(newTicket);
        Mockito.when(ticketSystemService.deleteFirstTicket()).thenReturn(deletedTicket);
        Mockito.when(ticketSystemService.showFirstTicket()).thenReturn(firstTicket);
        Mockito.when(ticketSystemService.getListOfTickets()).thenReturn(listOfTickets);
        Mockito.when(listOfTickets.size()).thenReturn(2);

        Mockito.when(newTicket.getTicketNbr()).thenReturn(2L);
        Mockito.when(newTicket.getEmissionTime()).thenReturn("2019-01-01 12:12");

        Mockito.when(firstTicket.getTicketNbr()).thenReturn(3L);
        Mockito.when(firstTicket.getEmissionTime()).thenReturn("2019-01-01 12:13");

        Mockito.when(deletedTicket.getTicketNbr()).thenReturn(4L);
        Mockito.when(deletedTicket.getEmissionTime()).thenReturn("2019-01-01 12:14");

        }

    @Test
    public void generateNewTicketTest() {
        String result = mainController.generateNewTicket();
        Mockito.verify(ticketSystemService).generateNewTicket();
        Assert.assertEquals(newTicketJson, result);
    }

    @Test
    public void deleteFirstTicketTest() {
        String result = mainController.deleteFirstTicket();
        Mockito.verify(ticketSystemService).deleteFirstTicket();
        Assert.assertEquals(deletedTicketJson, result);
    }


    @Test
    public void showTicketTest() {
        String result = mainController.showFirstTicket();
        Mockito.verify(ticketSystemService).showFirstTicket();
        Assert.assertEquals(firstTicketJson, result);
    }


}