package com.salesianos.triana.ComiendoPorTriana.exception;

import javax.persistence.EntityNotFoundException;

public class BarNotFoundException extends EntityNotFoundException {

    public BarNotFoundException() {super("La lista de bares no se encuentra...");}
}
