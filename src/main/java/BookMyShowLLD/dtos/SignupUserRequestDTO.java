package BookMyShowLLD.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupUserRequestDTO {
    private String name;
    private String email;
    private String password;
}
