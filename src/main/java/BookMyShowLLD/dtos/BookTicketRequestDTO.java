package BookMyShowLLD.dtos;

import lombok.Data;

import java.util.List;

@Data
public class BookTicketRequestDTO {
    private List<Integer> showSeatIds;
    private int userId;
}
