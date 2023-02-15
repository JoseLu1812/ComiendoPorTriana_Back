package com.salesianos.triana.ComiendoPorTriana.exception;

import javax.persistence.EntityNotFoundException;

public class BarNotFoundException extends EntityNotFoundException {

    public BarNotFoundException(String msg) {super(msg);}
}
