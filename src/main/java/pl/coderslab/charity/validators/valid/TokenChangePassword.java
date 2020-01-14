package pl.coderslab.charity.validators.valid;

import pl.coderslab.charity.dtos.PasswordDTO;
import pl.coderslab.charity.validators.config.SamePasswords;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TokenChangePassword implements ConstraintValidator<SamePasswords, PasswordDTO> {
    @Override
    public void initialize(SamePasswords constraintAnnotation) {

    }

    @Override
    public boolean isValid(PasswordDTO passwordDTO, ConstraintValidatorContext constraintValidatorContext) {
        if (passwordDTO.getPassword() == null ||passwordDTO.getRePassword() == null) {
            return true;
        }
        boolean valid = passwordDTO.getPassword().equals(passwordDTO.getRePassword());
        if (!valid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Not Same Password")
                    .addPropertyNode("rePassword").addConstraintViolation();
        }
        return valid;
    }

}
