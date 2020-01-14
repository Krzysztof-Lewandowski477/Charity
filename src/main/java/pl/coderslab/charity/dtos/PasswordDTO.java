package pl.coderslab.charity.dtos;

import lombok.Data;
import pl.coderslab.charity.validators.config.SamePasswords;
import pl.coderslab.charity.validators.config.ValidPassword;

@Data @SamePasswords
public class PasswordDTO {
    @ValidPassword
    private String password;
    private String rePassword;
}
