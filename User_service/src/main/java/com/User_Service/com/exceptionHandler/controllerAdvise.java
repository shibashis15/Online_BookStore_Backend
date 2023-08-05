package com.User_Service.com.exceptionHandler;

import com.User_Service.com.Exceptions.UserNotPresent;
import com.User_Service.com.util.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class controllerAdvise {
    @ExceptionHandler(value = {UserNotPresent.class})
    public ResponseEntity<ErrorResponse> UserNotPresentHandler(UserNotPresent userNotPresent) {
        ErrorResponse errorResponse = new ErrorResponse(userNotPresent.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
