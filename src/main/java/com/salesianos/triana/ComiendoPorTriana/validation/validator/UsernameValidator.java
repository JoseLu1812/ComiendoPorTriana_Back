package com.salesianos.triana.ComiendoPorTriana.validation.validator;

import com.salesianos.triana.ComiendoPorTriana.user.service.UserService;
import com.salesianos.triana.ComiendoPorTriana.validation.annotation.UsernameNotRepeat;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<UsernameNotRepeat, String> {

    @Autowired
    private UserService service;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return service.usernameExist(username);
    }
}
