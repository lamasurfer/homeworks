package com.example.jdata_hibernate.exception;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@ControllerAdvice
public class AppExceptionHandler {

    private final MessageSourceAccessor messages;

    public AppExceptionHandler(MessageSourceAccessor messages) {
        this.messages = messages;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        final String message = messages.getMessage("invalid.input");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        final String message = messages.getMessage("invalid.input");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MissingServletRequestParameterException e) {
        final String message = messages.getMessage("invalid.input");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(ConstraintViolationException e) {
        final String message = e.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .sorted()
                .collect(Collectors.joining(", "));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        final BindingResult result = e.getBindingResult();
        final String message = result.getAllErrors()
                .stream()
                .map(messages::getMessage)
                .sorted()
                .collect(Collectors.joining(", "));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException e) {
        final String message = messages.getMessage("not.found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Object> handleNoSuchElementException(EmptyResultDataAccessException e) {
        final String message = messages.getMessage("not.found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
