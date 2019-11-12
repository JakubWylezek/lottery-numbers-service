package com.lottery.numbers.service.exceptions;

import com.lottery.numbers.service.exceptions.custom.NotFoundEntityException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildResponseEntity(ApiError.builder()
                .status(status)
                .message("Invalid request")
                .timestamp(LocalDateTime.now())
                .errorMessage(ex.getLocalizedMessage()).build());
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildResponseEntity(ApiError.builder()
                .status(status).message("Invalid request method")
                .timestamp(LocalDateTime.now())
                .errorMessage(ex.getLocalizedMessage()).build());
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildResponseEntity(ApiError.builder()
                .status(status)
                .message("Invalid JSON object")
                .timestamp(LocalDateTime.now())
                .errorMessage(ex.getLocalizedMessage()).build());
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildResponseEntity(ApiError.builder()
                .status(status)
                .message("Invalid media type")
                .timestamp(LocalDateTime.now())
                .errorMessage(ex.getLocalizedMessage()).build());

    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildResponseEntity(ApiError.builder()
                .status(status)
                .message(ex.getParameterName() + " parameter is missing")
                .timestamp(LocalDateTime.now())
                .errorMessage(ex.getLocalizedMessage()).build());

    }

    @ExceptionHandler(NotFoundEntityException.class)
    protected ResponseEntity<Object> handleEntityNotFound(RuntimeException ex) {
        return buildResponseEntity(ApiError.builder()
                .status(HttpStatus.NOT_FOUND)
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage()).build());
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
