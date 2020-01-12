package pl.coderslab.charity.validators.valid;

import pl.coderslab.charity.dtos.RegistrationDataDTO;
import pl.coderslab.charity.validators.config.SamePasswords;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SamePasswordValidator implements ConstraintValidator<SamePasswords, RegistrationDataDTO> {

    public void initialize(SamePasswords constraint) {
    }

    public boolean isValid(RegistrationDataDTO registrationData, ConstraintValidatorContext context) {
        if (registrationData.getPassword () == null || registrationData.getRePassword () == null) {
            return true;
        } else {
            boolean valid = registrationData.getPassword ().equals ( registrationData.getRePassword () );
            if (!valid) {
                context.disableDefaultConstraintViolation ();
                context.buildConstraintViolationWithTemplate ( "SamePassword.registrationData.rePassword" )
                        .addPropertyNode ( "rePassword" ).addConstraintViolation ();
            }
            return valid;
        }
    }
}
