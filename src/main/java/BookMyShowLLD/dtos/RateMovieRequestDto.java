package BookMyShowLLD.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RateMovieRequestDto {
    private int userId;
    private int movieId;
    private int rating;
    private String review;
}
