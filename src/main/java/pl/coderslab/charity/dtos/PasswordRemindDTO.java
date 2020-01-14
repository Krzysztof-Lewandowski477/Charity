package pl.coderslab.charity.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
@Data
public class PasswordRemindDTO {
    @Email
    private String email;
}
