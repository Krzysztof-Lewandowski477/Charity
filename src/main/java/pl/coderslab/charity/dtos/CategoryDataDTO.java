package pl.coderslab.charity.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CategoryDataDTO {

    private Long id;
    @NotBlank @Size(min=3)
    private String name;


}
