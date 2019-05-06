package cz.jasterov.ticketsystem.service;

import cz.jasterov.ticketsystem.dao.Repository;
import cz.jasterov.ticketsystem.entity.Ticket;
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
public class TicketSystemServiceImplTest {

    @InjectMocks
    private TicketSystemServiceImpl ticketService;

    @Mock
    private Repository ticketRepository;

    @Mock
    private Ticket newTicket;

    @Mock
    private Ticket deletedTicket;

    @Mock
    private Ticket firstTicket;

    @Mock
    private List<Ticket> listOfTickets;

    @Before
    public void setUp() {
        Mockito.when(ticketRepository.generateNewTicket())
                .thenReturn(newTicket);
        Mockito.when(ticketRepository.deleteFirstTicket())
                .thenReturn(deletedTicket);
        Mockito.when(ticketRepository.showFirstTicket())
                .thenReturn(firstTicket);
        Mockito.when(ticketRepository.getListOfTickets())
                .thenReturn(listOfTickets);
    }


    @Test
    public void generateNewTicketTest() {
        Ticket result = ticketService.generateNewTicket();
        Mockito.verify(ticketRepository).generateNewTicket();
        Assert.assertEquals(
                newTicket,
                result
        );
    }

    @Test
    public void deleteFirstTicketTest() {
        Ticket result = ticketService.deleteFirstTicket();
        Mockito.verify(ticketRepository).deleteFirstTicket();
        Assert.assertEquals(
                deletedTicket,
                result
        );
    }

    @Test
    public void showFirstTicketTest() {
        Ticket result = ticketService.showFirstTicket();
        Mockito.verify(ticketRepository).showFirstTicket();
        Assert.assertEquals(
                firstTicket,
                result
        );
    }

    @Test
    public void getListOfTicketsTest() {
        List<Ticket> result = ticketService.getListOfTickets();
        Mockito.verify(ticketRepository).getListOfTickets();
        Assert.assertEquals(
                listOfTickets,
                result
        );
    }
}
