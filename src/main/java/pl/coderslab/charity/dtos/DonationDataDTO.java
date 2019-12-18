package pl.coderslab.charity.dtos;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.domain.entities.Category;
import pl.coderslab.charity.domain.entities.Institution;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class DonationDataDTO {

    private Long id;
    @NotNull
    private Integer quantity;
    @NotBlank
    private String street;
    @NotBlank
    private String city;
    @NotNull
    private String zipCode;
    @Size(min=9, max=9)
    @NotNull
    private Integer telephoneNumber;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @NotNull
    private LocalTime pickUpTime;

    private String pickUpComment;

    private List<Category> categories = new ArrayList<> ();
    private Institution institution;
}
