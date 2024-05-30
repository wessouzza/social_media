package com.example.social_media.controllers;

import java.util.List;

import com.example.social_media.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.social_media.dtos.responseDto.UserResponseDto;
import com.example.social_media.entities.User;
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

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllPageable(@RequestParam int page,@RequestParam int pageSize){
        List<UserResponseDto> users = userService.getAllUsersPageable(page, pageSize);
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id){
        UserResponseDto foundUser = userService.findById(id);
        return ResponseEntity.ok().body(foundUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateuser(@RequestBody UserDto user, @PathVariable Long id){
        UserResponseDto userToUpdate = userService.updateUser(user, id);
        return ResponseEntity.ok().body(userToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}