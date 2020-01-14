package pl.coderslab.charity.validators.config;

import pl.coderslab.charity.validators.valid.SamePasswordValidator;
import pl.coderslab.charity.validators.valid.TokenChangePassword;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {SamePasswordValidator.class, TokenChangePassword.class})
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SamePasswords {
    String message() default "This is not the same password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
