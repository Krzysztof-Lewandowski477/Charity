package pl.coderslab.charity.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class InstitutionDataDTO {


    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;

}
