package BookMyShowLLD.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAverageMovieResponseDto {
    private ResponseStatus responseStatus;
    private double averageRating;
}
