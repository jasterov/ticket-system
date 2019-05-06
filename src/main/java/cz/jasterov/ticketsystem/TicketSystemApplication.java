package cz.jasterov.ticketsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class TicketSystemApplication {

	public static void main(String[] args) {

    SpringApplication app = new SpringApplicationBuilder()
            .sources(TicketSystemApplication.class)
            .build();
        app.run(args);


    }
}
