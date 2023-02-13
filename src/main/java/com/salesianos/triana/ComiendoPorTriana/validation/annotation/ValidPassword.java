package com.salesianos.triana.ComiendoPorTriana.validation.annotation;

import com.salesianos.triana.ComiendoPorTriana.validation.validator.PasswordConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordConstraintValidator.class)
@Documented
public @interface ValidPassword {

    String message() default "Contraseña inválida";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
