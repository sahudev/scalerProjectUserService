package com.demo.users.exceptions;

public class InvalidUserException extends Exception{
    public InvalidUserException(String message){
        super(message);
    }
}