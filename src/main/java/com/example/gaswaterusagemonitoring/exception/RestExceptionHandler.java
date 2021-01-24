package com.example.gaswaterusagemonitoring.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Error> handleEntityNotFound(
            EntityNotFoundException ex) {
        Error error = new Error(ex.getMessage(), ex);
        return buildResponseEntity(error, NOT_FOUND);
    }

    private ResponseEntity<Error> buildResponseEntity(Error error, HttpStatus status) {
        return ResponseEntity.status(status).body(error);
    }

}
