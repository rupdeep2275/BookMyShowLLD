package BookMyShowLLD.controllers;

import BookMyShowLLD.dtos.CreateShowRequestDTO;
import BookMyShowLLD.dtos.CreateShowResponseDTO;
import BookMyShowLLD.dtos.ResponseStatus;
import BookMyShowLLD.models.Show;
import BookMyShowLLD.services.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/show")
public class ShowController {

    private final ShowService showService;

    @PostMapping("/add")
    public CreateShowResponseDTO createShow(@RequestBody CreateShowRequestDTO requestDTO) {
        CreateShowResponseDTO responseDTO = new CreateShowResponseDTO();
        try{
            Show show = showService.createShow(requestDTO.getUserId(), requestDTO.getMovieId(), requestDTO.getScreenId(), requestDTO.getStartTime(), requestDTO.getEndTime(), requestDTO.getPricingConfig(), requestDTO.getFeatures());
            responseDTO.setShow(show);
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e){
            e.printStackTrace();
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}
