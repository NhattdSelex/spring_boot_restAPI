package com.jttrinh.restfullapi.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class CustomizeResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
        ErrorDetail errorDetail = new ErrorDetail(LocalDate.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<Object>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetail> handleUserNotFoundException(Exception ex, WebRequest request){
        ErrorDetail errorDetail = new ErrorDetail(LocalDate.now(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<ErrorDetail>(errorDetail, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(LocalDate.now(), ex.getFieldError().getDefaultMessage(), request.getDescription(false));
        return new ResponseEntity<Object>(errorDetail, HttpStatus.BAD_REQUEST);
    }
}
