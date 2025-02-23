package BookMyShowLLD.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupUserResponseDTO {
    private ResponseStatus responseStatus;
    private String name;
    private String email;
    private int userId;
}
