package com.example.social_media.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.social_media.dtos.responseDto.UserResponseDto;
import com.example.social_media.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);

    List<User> findAllPageable(Pageable pageable);
}