package pl.coderslab.charity.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class RegistrationDataDTO {

    @NotBlank
    @Email
    private String email;
    private String password;
    private String rePassword;
}
