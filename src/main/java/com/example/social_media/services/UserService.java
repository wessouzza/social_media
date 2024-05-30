package com.example.social_media.services;

import java.util.List;
import java.util.stream.Collectors;

import com.example.social_media.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.social_media.dtos.responseDto.ResponseMapper;
import com.example.social_media.dtos.responseDto.UserResponseDto;
import com.example.social_media.entities.User;
import com.example.social_media.exceptions.UserNotFoundException;
import com.example.social_media.repositories.UserRepository;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private final String USER_ERROR_MESSAGE = "User not found.";
    

    public List<UserResponseDto> findAll(){
        List<UserResponseDto> userDtos = userRepository.findAll()
            .stream().map(ResponseMapper::toUserResponseDto).collect(Collectors.toList());

        if(userDtos.isEmpty()){
            throw new UserNotFoundException("There's no users yet.");
        }
        return userDtos;
    }

    public List<UserResponseDto> getAllUsersPageable(int page, int pageSize){
        List<User> users = userRepository.findAllPageable(PageRequest.of(page, pageSize));
        List<UserResponseDto> userResponse = users.stream().map(ResponseMapper::toUserResponseDto)
                .collect(Collectors.toList());
        return userResponse;
    }

    public UserResponseDto findById(long id){ 
        UserResponseDto user = userRepository.findById(id)
            .stream().map(ResponseMapper::toUserResponseDto).findFirst()
            .orElseThrow(()-> new UserNotFoundException(USER_ERROR_MESSAGE));
        
        return user;
    }

    public UserResponseDto updateUser(UserDto userDto, Long id){
        User userToUpdate = userRepository.findById(id)
            .orElseThrow(()-> new UserNotFoundException(USER_ERROR_MESSAGE));
        
        userToUpdate.setName(userDto.getName());
        userToUpdate.setEmail(userDto.getEmail());
        userToUpdate.setPassword(userDto.getPassword());
        userRepository.save(userToUpdate);

        return ResponseMapper.toUserResponseDto(userToUpdate);
    }

    public void deleteUser(Long id){
        User user = userRepository.findById(id)
            .orElseThrow(()-> new UserNotFoundException(USER_ERROR_MESSAGE));
        
        userRepository.delete(user);
    }
}