package pl.coderslab.charity.validators.config;

import pl.coderslab.charity.validators.valid.AttemptedRemovalAdmin;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = AttemptedRemovalAdmin.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AttemptedRemoval {



        String message() default "{krissto87.charity.validation.constraints.ActiveAdmin.message}";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};

}
