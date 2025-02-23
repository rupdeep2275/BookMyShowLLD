package BookMyShowLLD.dtos;

import BookMyShowLLD.models.Show;
import lombok.Data;

@Data
public class CreateShowResponseDTO {
    private ResponseStatus responseStatus;
    private Show show;
}
