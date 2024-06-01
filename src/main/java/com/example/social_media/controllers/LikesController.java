package com.example.social_media.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.social_media.dtos.LikesDto;
import com.example.social_media.dtos.responseDto.LikeResponseDto;
import com.example.social_media.services.LikeService;

@RestController
@RequestMapping("/likes")
public class LikesController {
    @Autowired
    private LikeService likeService;

    @PostMapping("/post/{id}")
    public ResponseEntity<LikeResponseDto> likePost(@PathVariable long id, @RequestBody LikesDto like){
        LikeResponseDto newLike = likeService.likePost(id, like);
        return ResponseEntity.ok().body(newLike);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<List<LikeResponseDto>> getLikesByPost(@PathVariable long id){
        List<LikeResponseDto> likes = likeService.getLikesByPost(id);
        return ResponseEntity.ok().body(likes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeLike(@PathVariable Long id){
        likeService.removeLike(id);
        return ResponseEntity.noContent().build();
    }
    
}