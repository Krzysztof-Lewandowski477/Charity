package pl.coderslab.charity.validators.config;


import pl.coderslab.charity.validators.valid.PasswordValidators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidators.class)
@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {

    String message() default "Bad Password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
