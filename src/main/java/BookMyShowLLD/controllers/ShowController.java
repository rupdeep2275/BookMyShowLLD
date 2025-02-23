package BookMyShowLLD.controllers;

import BookMyShowLLD.dtos.CreateShowRequestDTO;
import BookMyShowLLD.dtos.CreateShowResponseDTO;
import BookMyShowLLD.dtos.ResponseStatus;
import BookMyShowLLD.models.Show;
import BookMyShowLLD.services.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;

    public CreateShowResponseDTO createShow(CreateShowRequestDTO requestDTO) {
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
