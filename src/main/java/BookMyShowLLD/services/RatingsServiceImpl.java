package BookMyShowLLD.services;

import BookMyShowLLD.exceptions.MovieNotFoundException;
import BookMyShowLLD.exceptions.UserNotFoundException;
import BookMyShowLLD.models.Movie;
import BookMyShowLLD.models.Rating;
import BookMyShowLLD.models.User;
import BookMyShowLLD.repositories.MovieRepository;
import BookMyShowLLD.repositories.RatingRepository;
import BookMyShowLLD.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RatingsServiceImpl implements RatingsService {

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final RatingRepository ratingRepository;

    @Override
    public Rating rateMovie(int userId, int movieId, int rating) throws UserNotFoundException, MovieNotFoundException {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        Movie movie = this.movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException("Movie not found"));

        // Check if user has already rated the movie, then update the rating
        Optional<Rating> optionalRating = this.ratingRepository.findByUserAndMovie(user, movie);
        if(optionalRating.isPresent()){
            Rating ratingObj = optionalRating.get();
            ratingObj.setRating(rating);
            return this.ratingRepository.save(ratingObj);
        }

        Rating ratingObj = new Rating();
        ratingObj.setMovie(movie);
        ratingObj.setUser(user);
        ratingObj.setRating(rating);
        return this.ratingRepository.save(ratingObj);
    }

    @Override
    public double getAverageRating(int movieId) throws MovieNotFoundException {
        this.movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException("Movie not found"));
        return this.ratingRepository.getAverageRatingForMovie(movieId);
    }
}
