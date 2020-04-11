package book.ticket.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import book.ticket.app.dao.TicketBookingDao;
import book.ticket.app.entities.Ticket;

@Service
public class TicketBookingService {

	@Autowired
	private TicketBookingDao ticketBookingDao;

	public Ticket createTicket(Ticket ticket) {
		return ticketBookingDao.save(ticket);
	}

	public Optional<Ticket> getTicketById(Integer ticketId) {
		return ticketBookingDao.findById(ticketId);
	}

	public Iterable<Ticket> getAllBookedTickets() {
		return ticketBookingDao.findAll();
	}

	public void deleteTicket(Integer ticketId) {
		ticketBookingDao.deleteById(ticketId);
	}

	public Optional<Ticket> updateTicket(Integer ticketid, String newMail) {
		Optional<Ticket> ticketFromDb = ticketBookingDao.findById(ticketid);
		ticketFromDb.get().setEmail(newMail);
		return ticketBookingDao.findById(ticketid);
	}

}
