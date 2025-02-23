package BookMyShowLLD.dtos;

import BookMyShowLLD.models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDTO {
    private ResponseStatus status;
    private Ticket ticket;
}
