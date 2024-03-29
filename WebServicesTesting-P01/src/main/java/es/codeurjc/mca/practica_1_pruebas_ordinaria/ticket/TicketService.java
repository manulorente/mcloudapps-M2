package es.codeurjc.mca.practica_1_pruebas_ordinaria.ticket;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.mca.practica_1_pruebas_ordinaria.event.Event;
import es.codeurjc.mca.practica_1_pruebas_ordinaria.event.EventService;
import es.codeurjc.mca.practica_1_pruebas_ordinaria.user.User;
import es.codeurjc.mca.practica_1_pruebas_ordinaria.user.UserService;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

	public Ticket createTicket(Long eventId) {
        User user = userService.getMe();
        Event event = eventService.getEvent(eventId);

        // Check for remaining tickets
        eventService.bookTicket(eventId);

        Ticket ticket = new Ticket(user, event);
        ticketRepository.save(ticket);
        return ticket;
		
	}

	public Optional<Ticket> getTicket(long id) {
		return ticketRepository.findById(id);
    }
    
    public void deleteTicket(Ticket ticket) {
        eventService.releaseTicket(ticket.getEvent().getId());
        ticketRepository.delete(ticket);
    }

	public boolean belongsToMe(Ticket ticket) {
        long id = userService.getMe().getId();
        return userService.getIfIAdmin() || ticket.getCustomer().getId().equals(id);
	}

}
