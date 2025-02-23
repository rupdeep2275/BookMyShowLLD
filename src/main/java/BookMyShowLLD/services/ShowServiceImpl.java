package BookMyShowLLD.services;

import BookMyShowLLD.exceptions.*;
import BookMyShowLLD.models.*;
import BookMyShowLLD.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ShowServiceImpl implements ShowService{

    private final MovieRepository movieRepository;
    private final SeatsRepository seatsRepository;
    private final ScreenRepository screenRepository;
    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;
    private final SeatTypeShowRepository seatTypeShowRepository;
    private final UserRepository userRepository;

    @Override
    public Show createShow(int userId, int movieId, int screenId, Date startTime, Date endTime, List<Pair<SeatType, Double>> pricingConfig, List<Feature> features) throws MovieNotFoundException, ScreenNotFoundException, FeatureNotSupportedByScreen, InvalidDateException, UserNotFoundException, UnAuthorizedAccessException {
        User admin = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        if(!admin.getUserType().equals(UserType.ADMIN)){
            throw new UnAuthorizedAccessException("User not authorized to create show");
        }
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException("Movie not found"));
        Screen screen = screenRepository.findById(screenId).orElseThrow(() -> new ScreenNotFoundException("Screen not found"));

        //Validations
        Set<Feature> screenFeatures = new HashSet<>(screen.getFeatures());
        for(Feature feature: features){
            if(!screenFeatures.contains(feature)){
                throw new FeatureNotSupportedByScreen("Feature not supported by screen");
            }
        }

        Date now = new Date();
        if(startTime.before(now) ){
            throw new InvalidDateException("Start time cannot be before current time");
        }
        if(endTime.before(startTime)){
            throw new InvalidDateException("End time cannot be before start time");
        }

        // Create show
        Show show = new Show();
        show.setMovie(movie);
        show.setScreen(screen);
        show.setStartTime(startTime);
        show.setEndTime(endTime);
        show.setFeatures(features);
        show = showRepository.save(show);

        // Create show seats
        List<Seat> seats = seatsRepository.findAllByScreenId(screenId);
        List<ShowSeat> showSeats = new ArrayList<>();
        for(Seat seat: seats){
            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeat(seat);
            showSeat.setShow(show);
            showSeat.setStatus(SeatStatus.AVAILABLE);
            showSeats.add(showSeat);
        }
        showSeatRepository.saveAll(showSeats);

        // Store Pricing information
        for(Pair<SeatType, Double> pair: pricingConfig){
            SeatType seatType = pair.getFirst();
            Double price = pair.getSecond();
            SeatTypeShow  seatTypeShow = new SeatTypeShow();
            seatTypeShow.setSeatType(seatType);
            seatTypeShow.setShow(show);
            seatTypeShow.setPrice(price);
            seatTypeShowRepository.save(seatTypeShow);
        }
        return show;
    }
}
