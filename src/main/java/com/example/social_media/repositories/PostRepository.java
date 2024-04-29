package com.example.social_media.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.social_media.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
    //Post findById(long id);
}