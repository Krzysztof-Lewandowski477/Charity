package pl.coderslab.charity.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class InstitutionDataDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
}
