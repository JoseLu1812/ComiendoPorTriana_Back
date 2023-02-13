package com.salesianos.triana.ComiendoPorTriana.exception;

import javax.persistence.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {

    public UserNotFoundException() {super("Usuario no encontrado");}

}
