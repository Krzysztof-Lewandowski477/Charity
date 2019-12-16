package pl.coderslab.charity.dtos;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
@Data
public class DonationDataDTO {

    @NotNull
    private Integer quantity;
    @NotBlank
    private String street;
    @NotBlank
    private String city;
    @NotNull
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime pickUpTime;
    @NotBlank
    private String pickUpComment;
}
