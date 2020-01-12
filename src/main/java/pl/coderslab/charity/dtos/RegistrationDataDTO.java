package pl.coderslab.charity.dtos;

import lombok.Data;
import pl.coderslab.charity.validators.config.SamePasswords;
import pl.coderslab.charity.validators.config.ValidPassword;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data @SamePasswords
public class RegistrationDataDTO {

    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @ValidPassword
    private String password;
    private String rePassword;
}
