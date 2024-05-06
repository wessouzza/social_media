package com.example.social_media.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.social_media.dtos.PostsDto;
import com.example.social_media.dtos.UserDto;
import com.example.social_media.dtos.mapper.ModelMapper;
import com.example.social_media.dtos.responseDto.PostResponseDto;
import com.example.social_media.dtos.responseDto.ResponseMapper;
import com.example.social_media.entities.Likes;
import com.example.social_media.entities.Post;
import com.example.social_media.entities.User;
import com.example.social_media.exceptions.PostNotFoundException;
import com.example.social_media.exceptions.UserNotFoundException;
import com.example.social_media.repositories.PostRepository;
import com.example.social_media.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    private final String POST_ERROR_MESSAGE = "Post not found.";
    

    public PostResponseDto createPost(PostsDto postDto, long id){
        User user = userRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("User not found."));
        
        PostsDto newPost = new PostsDto();
        newPost.setBody(postDto.getBody());
        newPost.setPublicationDate(LocalDateTime.now());
        newPost.setUser(user);
        user.getPosts().add(ModelMapper.toPost(postDto));
        userRepository.save(user);

        return ResponseMapper.toPostResponseDto(postRepository.save(ModelMapper.toPost(newPost)));
    }

    public List<PostResponseDto> findUserPosts(long id){
        User user = userRepository.findById(id)
            .orElseThrow(()-> new EntityNotFoundException("User not found"));
        UserDto uDto = ModelMapper.toUserDto(user);    
        List<PostResponseDto> posts = uDto.getPosts()
            .stream().map(ResponseMapper::toPostResponseDto).collect(Collectors.toList());
        return posts;
    }

    public PostResponseDto updatePost(PostsDto post, Long id){
        Post postToUpdate = postRepository.findById(id)
            .orElseThrow(()-> new PostNotFoundException(POST_ERROR_MESSAGE));
        postToUpdate.setBody(post.getBody());
        postRepository.save(postToUpdate);
        return ResponseMapper.toPostResponseDto(postToUpdate);
    }

    public void deletePost(Long id){
        Post post = postRepository.findById(id)
            .orElseThrow(()-> new PostNotFoundException(POST_ERROR_MESSAGE));
        postRepository.delete(post);
    }
    
    public int countLikes(Long id){
        Post post = postRepository.findById(id)
            .orElseThrow(()-> new PostNotFoundException(POST_ERROR_MESSAGE));
        return post.getLikes().size();
    }

    public int countComments(Long id){
        Post post = postRepository.findById(id)
            .orElseThrow(()-> new PostNotFoundException(POST_ERROR_MESSAGE));
        return post.getComments().size();
    }
}