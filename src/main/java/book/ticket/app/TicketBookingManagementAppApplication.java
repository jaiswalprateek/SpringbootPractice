package book.ticket.app;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import book.ticket.app.entities.Ticket;
import book.ticket.app.service.TicketBookingService;

@SpringBootApplication
public class TicketBookingManagementAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication
				.run(TicketBookingManagementAppApplication.class, args);

		TicketBookingService ticketBookingService = applicationContext.getBean("ticketBookingService",
				TicketBookingService.class);
		
		Ticket ticket=new Ticket();
		ticket.setBookingDate(new Date());
		ticket.setDestStation("Meerut");
		ticket.setSourceStation("Noida");
		ticket.setEmail("prateekjaiswal92@gmail.com");
		ticket.setPassangerName("Prateek Jaiswal");
		
		ticketBookingService.createTicket(ticket);
	}
}
