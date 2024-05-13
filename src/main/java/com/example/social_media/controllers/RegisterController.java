package com.example.social_media.controllers;

import com.example.social_media.dtos.UserDto;
import com.example.social_media.dtos.responseDto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.social_media.entities.User;
import com.example.social_media.services.RegisterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody @Valid UserDto user){
        UserResponseDto newUser = registerService.createUser(user);
        return ResponseEntity.ok().body(newUser);       
    }
}