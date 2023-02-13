package com.salesianos.triana.ComiendoPorTriana.error.controller;

import com.salesianos.triana.ComiendoPorTriana.error.model.impl.ApiErrorImpl;
import com.salesianos.triana.ComiendoPorTriana.error.model.impl.ApiValidationSubError;
import com.salesianos.triana.ComiendoPorTriana.exception.CommentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CommentErrorController {

    @ExceptionHandler({CommentNotFoundException.class})
    public ResponseEntity<?> handleNotFoundException(EntityNotFoundException exception, WebRequest request){
        return buildApiError(exception.getMessage(), request, HttpStatus.NOT_FOUND);
    }

    private final ResponseEntity<Object> buildApiError(String message, WebRequest request, HttpStatus status){
        return ResponseEntity
                .status(status)
                .body(
                        ApiErrorImpl.builder()
                                .status(status)
                                .message(message)
                                .path(((ServletWebRequest) request).getRequest().getRequestURI())
                                .build()
                );
    }

    private final ResponseEntity<Object> buildApiErrorWithErrors(String message, WebRequest request, HttpStatus status, List<ObjectError> subsErrors) {
        return  ResponseEntity
                .status(status)
                .body(
                        ApiErrorImpl.builder()
                                .status(status)
                                .message(message)
                                .path(((ServletWebRequest) request).getRequest().getRequestURI())
                                .subErrors(subsErrors.stream()
                                        .map(ApiValidationSubError::fromObjectError)
                                        .collect(Collectors.toList())
                                )
                                .build()
                );
    }
}
