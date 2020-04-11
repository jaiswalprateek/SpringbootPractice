package book.ticket.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import book.ticket.app.entities.Ticket;

@Repository //--optional
public interface TicketBookingDao extends CrudRepository<Ticket, Integer>{


}
