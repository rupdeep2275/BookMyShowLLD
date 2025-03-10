package BookMyShowLLD.dtos;

import BookMyShowLLD.models.Show;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateShowResponseDTO {
    private ResponseStatus responseStatus;
    private Show show;
}
