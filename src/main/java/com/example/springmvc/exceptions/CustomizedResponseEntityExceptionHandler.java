package com.example.springmvc.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {

        ExceptionResponse exceptionResponse =  new ExceptionResponse(ex.getMessage(),new Date(),request.getDescription(false));

        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {

        ExceptionResponse exceptionResponse =  new ExceptionResponse(ex.getMessage(),new Date(),request.getDescription(false));

        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ExceptionResponse exceptionResponse =  new ExceptionResponse(ex.getBindingResult().toString(),new Date(),"validation error");
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);

    }

//    @ExceptionHandler(UserNotFoundException.class)
//    public final ResponseEntity<Object> handleAllException(UserNotFoundException ex, WebRequest request) throws Exception {
//
//        ExceptionResponse exceptionResponse =  new ExceptionResponse(ex.getMessage(),new Date(),request.getDescription(false));
//
//        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
//
//    }


    }
