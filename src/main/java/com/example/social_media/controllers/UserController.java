package com.example.social_media.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.social_media.dtos.responseDto.UserResponseDto;
import com.example.social_media.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAll(){
        List<UserResponseDto> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id){
        UserResponseDto foundUser = userService.findById(id);
        return ResponseEntity.ok().body(foundUser);
    }

}