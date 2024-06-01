package com.example.social_media.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.social_media.entities.Likes;

public interface LikesRepository extends JpaRepository<Likes, Long>{
    
}