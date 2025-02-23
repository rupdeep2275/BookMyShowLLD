package BookMyShowLLD.controllers;

import BookMyShowLLD.dtos.BookTicketRequestDTO;
import BookMyShowLLD.dtos.BookTicketResponseDTO;
import BookMyShowLLD.dtos.ResponseStatus;
import BookMyShowLLD.models.Ticket;
import BookMyShowLLD.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public BookTicketResponseDTO bookTicket(BookTicketRequestDTO requestDTO){
        BookTicketResponseDTO responseDTO = new BookTicketResponseDTO();
        try {
            Ticket ticket = ticketService.bookTicket(requestDTO.getShowSeatIds(), requestDTO.getUserId());
            responseDTO.setTicket(ticket);
            responseDTO.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception e){
            responseDTO.setStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}
