package com.salesianos.triana.ComiendoPorTriana.validation.annotation;

import com.salesianos.triana.ComiendoPorTriana.validation.validator.UsernameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UsernameValidator.class)
@Documented
public @interface UsernameNotRepeat {

    String message() default "El nombre de Usuario ya existe.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
