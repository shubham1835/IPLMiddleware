package com.ipl.middleware.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
@Slf4j
public class GlobleExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return error(ex.getMessage(), HttpStatus.NOT_FOUND, request, 404);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> details = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        return error(details.get(0), HttpStatus.BAD_REQUEST, request, 400);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> globalExceptionHandler(Exception ex, WebRequest request) {
        return error(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, request, 500);
    }

    @ExceptionHandler(ResponseEntityException.class)
    public ResponseEntity<Object> responseEntityExceptionHandler(ResponseEntityException ex, WebRequest request) {
        ErrorMessageConstant errorMessageConstant = ex.getErrorMessageConstant();
        return error(errorMessageConstant.getMessage(), errorMessageConstant.getStatus(), request, errorMessageConstant.getStatusCode());
    }

    private ResponseEntity<Object> error(String exceptionMessage, HttpStatus httpStatus, WebRequest request, int errorCode) {
        ErrorMessage message = new ErrorMessage(
                httpStatus.value(),
                new Date(),
                exceptionMessage,
                request.getDescription(false),
                errorCode
        );
        return new ResponseEntity<>(message, httpStatus);

    }

}
