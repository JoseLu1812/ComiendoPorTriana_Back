package com.salesianos.triana.ComiendoPorTriana.exception;

public class NotOwnerException extends SecurityException{

    public NotOwnerException(String text){
        super(text);
    }
}
