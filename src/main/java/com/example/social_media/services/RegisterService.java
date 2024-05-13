package com.example.social_media.services;

import java.util.Optional;

import com.example.social_media.dtos.UserDto;
import com.example.social_media.dtos.responseDto.ResponseMapper;
import com.example.social_media.dtos.responseDto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.example.social_media.entities.User;
import com.example.social_media.exceptions.CustomDataIntegrityViolationException;
import com.example.social_media.repositories.UserRepository;


@Service
public class RegisterService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public UserResponseDto createUser(UserDto userDto){
        User newUser = new User();
        String hashedPassword = passwordEncoder.encode(userDto.getPassword());
        newUser.setName(userDto.getName());
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(hashedPassword);
        emailValidation(userDto.getEmail());

        return ResponseMapper.toUserResponseDto(userRepository.save(newUser));
    }

    public void emailValidation(String email){
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            throw new CustomDataIntegrityViolationException("This email is already in use.");
        }

    }
}