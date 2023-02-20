package com.salesianos.triana.ComiendoPorTriana.exception;

public class StorageException extends RuntimeException{
    public StorageException(String text){
        super(text);
    }

    public StorageException(String text, Exception e) {
        super(text, e);
    }

}
