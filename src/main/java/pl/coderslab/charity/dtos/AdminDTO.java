package pl.coderslab.charity.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class AdminDTO {

    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @Email
    private String email;
}
