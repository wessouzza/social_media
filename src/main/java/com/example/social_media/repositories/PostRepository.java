package com.example.social_media.repositories;

import com.example.social_media.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.social_media.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
    Page<Post> findByUser(User user, Pageable pageable);
}