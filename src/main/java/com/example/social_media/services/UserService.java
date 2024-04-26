package com.example.social_media.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.social_media.dtos.responseDto.ResponseMapper;
import com.example.social_media.dtos.responseDto.UserResponseDto;
import com.example.social_media.exceptions.UserNotFoundException;
import com.example.social_media.repositories.UserRepository;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    

    public List<UserResponseDto> findAll(){
        List<UserResponseDto> userDtos = userRepository.findAll()
            .stream().map(ResponseMapper::toUserResponseDto).collect(Collectors.toList());
        return userDtos;
    }

    public UserResponseDto findById(long id){ 
        UserResponseDto user = userRepository.findById(id)
            .stream().map(ResponseMapper::toUserResponseDto).findFirst()
            .orElseThrow(()-> new UserNotFoundException("User not found."));
        
        return user;
    }

}