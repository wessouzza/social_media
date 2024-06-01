package com.example.social_media.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.social_media.dtos.LikesDto;
import com.example.social_media.dtos.responseDto.LikeResponseDto;
import com.example.social_media.dtos.responseDto.ResponseMapper;
import com.example.social_media.entities.Likes;
import com.example.social_media.entities.Post;
import com.example.social_media.repositories.LikesRepository;
import com.example.social_media.repositories.PostRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LikeService {
    @Autowired
    private LikesRepository likesRepository;
    @Autowired
    private PostRepository postRepository;
    

    public LikeResponseDto likePost(long id, LikesDto like){
        Post post = postRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Post no found."));
        Likes newLike = new Likes();
        newLike.setPost(post);
        for(Likes l : post.getLikes()){
            if(l.getUser().getId() == like.getUser().getId()){
                throw new RuntimeException("You can't like more the one time.");
            }
        }
        newLike.setUser(like.getUser());
        newLike.setLiked(true);
        post.getLikes().add(newLike);
        postRepository.save(post);

        return ResponseMapper.toLikeResponseDto(likesRepository.save(newLike));
    }

    public List<LikeResponseDto> getLikesByPost(long id){
        Post post = postRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Post not found."));
        List<LikeResponseDto> likes = post.getLikes().stream().map(ResponseMapper::toLikeResponseDto).collect(Collectors.toList());
        return likes;
    }

    public void removeLike(Long id){
        Likes likeToRemove = likesRepository.findById(id)
            .orElseThrow(()-> new EntityNotFoundException("Like not found."));
        likesRepository.delete(likeToRemove);
    }
}