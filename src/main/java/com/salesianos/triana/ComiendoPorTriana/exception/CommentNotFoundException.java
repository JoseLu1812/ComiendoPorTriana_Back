package com.salesianos.triana.ComiendoPorTriana.exception;

import javax.persistence.EntityNotFoundException;

public class CommentNotFoundException extends EntityNotFoundException {

    public CommentNotFoundException(String msg) {super(msg);}
}
