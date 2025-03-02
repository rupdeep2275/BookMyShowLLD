package BookMyShowLLD.services;

import BookMyShowLLD.models.Ticket;

import java.util.List;

public interface TicketService {

    Ticket bookTicket(List<Integer> showSeatIds, int userId) throws Exception;
}
