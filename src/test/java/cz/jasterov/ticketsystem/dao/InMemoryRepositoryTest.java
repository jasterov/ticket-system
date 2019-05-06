package cz.jasterov.ticketsystem.dao;

import cz.jasterov.ticketsystem.entity.Ticket;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class InMemoryRepositoryTest {

    private InMemoryRepository inMemoryRepository = new InMemoryRepository();

    @Before
    public void setUp() {
        inMemoryRepository.setTicketNbr(1L);
        inMemoryRepository.getListOfTickets().add(new Ticket(0L, "2019-01-01 12:12"));
    }

    @Test
    public void generateNewTicketTest() {
        inMemoryRepository.generateNewTicket();
        Assert.assertThat(inMemoryRepository.getListOfTickets().get(inMemoryRepository.getListOfTickets().size()-1),
                Matchers.allOf(
                        Matchers.hasProperty("ticketNbr", Matchers.equalTo(1L)),
                        Matchers.hasProperty("emissionTime",
                                Matchers.equalTo(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))))
                )
        );

        Assert.assertThat(
                inMemoryRepository.getTicketNbr(),
                Matchers.equalTo(2L)
        );
    }


    @Test
    public void showFirstTicketTest() {
        Assert.assertThat(inMemoryRepository.showFirstTicket(),
                Matchers.allOf(
                        Matchers.hasProperty("ticketNbr", Matchers.equalTo(0L)),
                        Matchers.hasProperty("emissionTime",
                                Matchers.equalTo("2019-01-01 12:12"))
                )
        );
        inMemoryRepository.deleteFirstTicket();

        Assert.assertThat(inMemoryRepository.showFirstTicket(),
                Matchers.allOf(
                        Matchers.hasProperty("ticketNbr", Matchers.equalTo(null)),
                        Matchers.hasProperty("emissionTime",
                                Matchers.equalTo(null))
                )
        );
    }

    @Test
    public void deleteFirstTicketTest() {
        Assert.assertThat(inMemoryRepository.deleteFirstTicket(),
                Matchers.allOf(
                        Matchers.hasProperty("ticketNbr", Matchers.equalTo(0L)),
                        Matchers.hasProperty("emissionTime",
                                Matchers.equalTo("2019-01-01 12:12"))
                )
        );

        Assert.assertThat(
                inMemoryRepository.getListOfTickets().size(),
                Matchers.equalTo(0)
        );

        Assert.assertThat(inMemoryRepository.deleteFirstTicket(),
                Matchers.allOf(
                        Matchers.hasProperty("ticketNbr", Matchers.equalTo(null)),
                        Matchers.hasProperty("emissionTime",
                                Matchers.equalTo(null))
                )
        );
    }
}