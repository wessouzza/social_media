package com.example.social_media.exceptions;

public class CustomDataIntegrityViolationException extends RuntimeException{
    public CustomDataIntegrityViolationException(String msg){
        super(msg);
    }
}