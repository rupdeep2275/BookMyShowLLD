package BookMyShowLLD.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {
    private boolean loggedIn;
    private ResponseStatus responseStatus;
}
