package com.example.demo.common.exceptions;

public class InvalidUserException extends RuntimeException{
    public InvalidUserException(String message){
        super(message);
    }

    public InvalidUserException(String message, Throwable cause){
        super(message, cause);
    }

}
