package BookMyShowLLD.controllers;

import BookMyShowLLD.dtos.*;
import BookMyShowLLD.dtos.ResponseStatus;
import BookMyShowLLD.models.Rating;
import BookMyShowLLD.services.RatingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rating")
public class RatingsController {

    private final RatingsService ratingsService;

    @PostMapping("/rate")
    public RateMovieResponseDto rateMovie(@RequestBody RateMovieRequestDto requestDto){
        RateMovieResponseDto responseDto = new RateMovieResponseDto();
        try{
            Rating rating = ratingsService.rateMovie(requestDto.getUserId(), requestDto.getMovieId(), requestDto.getRating(), requestDto.getReview());
            responseDto.setRating(rating);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            return responseDto;
        } catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            return responseDto;
        }
    }

    @GetMapping("{movieId}/get")
    public GetAverageMovieResponseDto getAverageMovieRating(@PathVariable Integer movieId){
        GetAverageMovieResponseDto responseDto = new GetAverageMovieResponseDto();
        try{
            double averageRating = ratingsService.getAverageRating(movieId);
            responseDto.setAverageRating(averageRating);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            return responseDto;
        } catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            return responseDto;
        }
    }
}
