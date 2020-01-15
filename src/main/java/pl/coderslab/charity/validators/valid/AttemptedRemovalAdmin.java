package pl.coderslab.charity.validators.valid;

import pl.coderslab.charity.dtos.DeleteAdminDTO;
import pl.coderslab.charity.util.Utils;
import pl.coderslab.charity.validators.config.AttemptedRemoval;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AttemptedRemovalAdmin implements ConstraintValidator<AttemptedRemoval, DeleteAdminDTO> {
    @Override
    public void initialize(AttemptedRemoval constraintAnnotation) {

    }

    @Override
    public boolean isValid(DeleteAdminDTO adminDTO, ConstraintValidatorContext context) {
        boolean valid = adminDTO.getEmail().equals( Utils.getName ());
        if (valid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("ActiveAdmin.admin.*")
                    .addConstraintViolation();
        }
        return !valid;
    }

}
