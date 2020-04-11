package book.ticket.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import book.ticket.app.entities.Ticket;
import book.ticket.app.service.TicketBookingService;

@RestController
@RequestMapping(value = "/api/tickets")
public class TicketBookingController {

	@Autowired
	private TicketBookingService ticketBookingService;

	@PostMapping(value = "/create")
	public Ticket createTicket(@RequestBody Ticket ticket) {
		return ticketBookingService.createTicket(ticket);
	}

	@GetMapping(value = "/ticket/{ticketId}")
//	@RequestMapping(value = "/ticket/{ticketId}")  //--both annotations are SAME
	public Optional<Ticket> getTicketById(@PathVariable("ticketId") Integer ticketId) {
		return ticketBookingService.getTicketById(ticketId);

	}

	@GetMapping(value = "/ticket/alltickets")
	public Iterable<Ticket> getAllBookedTicked() {
		return ticketBookingService.getAllBookedTickets();
	}

	@DeleteMapping(value = "/ticket/{ticketid}")
	public void deleteTicket(@PathVariable("ticketid") Integer ticketId) {
		ticketBookingService.deleteTicket(ticketId);

	}

	@PutMapping(value = "ticket/{ticketid}/{newEmail:.+}")
	public Optional<Ticket> updateTicket(@PathVariable("ticketid") Integer ticketId, @PathVariable("newEmail") String newMail) {
		return ticketBookingService.updateTicket(ticketId, newMail);
	}

}
