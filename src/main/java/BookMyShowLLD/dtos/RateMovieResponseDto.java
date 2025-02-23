package BookMyShowLLD.dtos;

import BookMyShowLLD.models.Rating;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RateMovieResponseDto {
    private ResponseStatus responseStatus;
    private Rating rating;
}
