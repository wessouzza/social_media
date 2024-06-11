package com.example.social_media.repositories;

import com.example.social_media.dtos.responseDto.CommentResponseDto;
import com.example.social_media.entities.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.social_media.entities.Comments;

public interface CommentRepository extends JpaRepository<Comments, Long>{
    Page<Comments> findByPost(Post post, Pageable pageable);
}