package com.User_Service.com.Exceptions;

public class UserNotPresent extends RuntimeException {
    public UserNotPresent(String message) {
        super(message);
    }
}
