package br.com.tanos.management.commons.config;

import br.com.tanos.management.commons.exception.LocalException;
import br.com.tanos.management.commons.exception.ObjectNotFoundException;
import br.com.tanos.management.commons.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler({
            ValidationException.class
    })
    public ResponseEntity errorValidationException(Exception ex) {
        return ResponseEntity.badRequest()
                .body(((LocalException)ex).getValidationMessages());
    }

    @ExceptionHandler({
            ObjectNotFoundException.class
    })
    public ResponseEntity errorObjectNotFoundException(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(((LocalException)ex).getValidationMessages());
    }

}
