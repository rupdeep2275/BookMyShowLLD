package BookMyShowLLD.services;

import BookMyShowLLD.exceptions.MovieNotFoundException;
import BookMyShowLLD.exceptions.UserNotFoundException;
import BookMyShowLLD.models.Rating;

public interface RatingsService {

    public Rating rateMovie(int userId, int movieId, int rating) throws UserNotFoundException, MovieNotFoundException;

    public double getAverageRating(int movieId) throws MovieNotFoundException;
}
