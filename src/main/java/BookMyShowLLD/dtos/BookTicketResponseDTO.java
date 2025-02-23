package BookMyShowLLD.dtos;

import BookMyShowLLD.models.Ticket;
import lombok.Data;

@Data
public class BookTicketResponseDTO {
    private ResponseStatus status;
    private Ticket ticket;
}
