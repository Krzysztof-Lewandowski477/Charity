package pl.coderslab.charity.dtos;

import lombok.Data;
import pl.coderslab.charity.validators.config.AttemptedRemoval;

@Data
@AttemptedRemoval
public class DeleteAdminDTO {

    private Long id;
    private String email;
}
