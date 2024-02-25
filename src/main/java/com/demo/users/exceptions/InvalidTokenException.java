package com.demo.users.exceptions;

public class InvalidTokenException extends Exception{
    public InvalidTokenException(String message){
        super(message);
    }
}