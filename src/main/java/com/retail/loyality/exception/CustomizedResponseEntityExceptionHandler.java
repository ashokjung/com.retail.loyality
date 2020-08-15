package com.retail.loyality.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ServiceExceptionHandler> handleAllExceptions(Exception ex, WebRequest request) {
        ServiceExceptionHandler exceptionResponse = new ServiceExceptionHandler(ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomerException.class)
    public final ResponseEntity<ServiceExceptionHandler> handleAllExceptions(CustomerException ex, WebRequest request) {
        ServiceExceptionHandler exceptionResponse = new ServiceExceptionHandler(ex.getMessage(),
                "Failure");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomerAddressException.class)
    public final ResponseEntity<ServiceExceptionHandler> handleAllExceptions(CustomerAddressException ex, WebRequest request) {
        ServiceExceptionHandler exceptionResponse = new ServiceExceptionHandler(ex.getMessage(),
                "Failure");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomerContactException.class)
    public final ResponseEntity<ServiceExceptionHandler> handleAllExceptions(CustomerContactException ex, WebRequest request) {
        ServiceExceptionHandler exceptionResponse = new ServiceExceptionHandler(ex.getMessage(),
                "Failure");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}