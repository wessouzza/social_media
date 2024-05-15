package com.example.social_media.controllers.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.social_media.exceptions.CommentNotFoundException;
import com.example.social_media.exceptions.CustomDataIntegrityViolationException;
import com.example.social_media.exceptions.PostNotFoundException;
import com.example.social_media.exceptions.UserNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<StandardError> userNotFound(UserNotFoundException e, HttpServletRequest request) {
        StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(CustomDataIntegrityViolationException.class)
    public ResponseEntity<StandardError> emailAlreadyInUse(CustomDataIntegrityViolationException e,
            HttpServletRequest request) {
        StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<StandardError> postNotFound(PostNotFoundException e, 
            HttpServletRequest request){
        StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), 
            e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(CommentNotFoundException.class)
    public ResponseEntity<StandardError> commentNotFound(CommentNotFoundException e, 
            HttpServletRequest request){
        StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}