package cz.jasterov.ticketsystem.controller;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class MainControllerITTest {

    @Autowired
    private MainController mainController;


    @Test
    public void generateNewTicketTest() {
        String result = mainController.generateNewTicket();
        String Json = "{ \"ticket_number\":\"0\", \"time\":\"" +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) +
                "\", \"order\": \"0\", \"status\":\"generated\"}";
        Assert.assertEquals(Json, result);

        mainController.generateNewTicket();
        String Json2 = "{ \"ticket_number\":\"0\", \"time\":\"" +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) +
                "\", \"order\": \"0\", \"status\":\"deleted\"}";
        String result2 = mainController.deleteFirstTicket();
        Assert.assertEquals(Json2, result2);

        String Json3 = "{ \"ticket_number\":\"1\", \"time\":\"" +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) +
                "\", \"order\": \"0\", \"status\":\"called\"}";
        String result3 = mainController.showFirstTicket();
        Assert.assertEquals(Json3, result3);

    }


}
