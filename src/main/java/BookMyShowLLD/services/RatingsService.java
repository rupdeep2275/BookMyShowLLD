package BookMyShowLLD.services;

import BookMyShowLLD.exceptions.MovieNotFoundException;
import BookMyShowLLD.exceptions.UserNotFoundException;
import BookMyShowLLD.models.Rating;

public interface RatingsService {

    Rating rateMovie(int userId, int movieId, int rating, String review) throws UserNotFoundException, MovieNotFoundException;

    double getAverageRating(int movieId) throws MovieNotFoundException;
}
