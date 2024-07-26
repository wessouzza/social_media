package com.example.social_media.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.social_media.dtos.PostsDto;
import com.example.social_media.dtos.responseDto.PostResponseDto;
import com.example.social_media.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/{id}/users")
    public PostResponseDto createPost(@RequestBody PostsDto postDto, @PathVariable long id){
        return postService.createPost(postDto, id);
    }

    @GetMapping("/{id}/users")
    public ResponseEntity<List<PostResponseDto>> findUserPosts(@PathVariable long id){
        List<PostResponseDto> posts = postService.findUserPosts(id);
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Page<PostResponseDto>> getPostsPageable(@PathVariable Long id, @RequestParam int page,
                                                                  @RequestParam int pageSize){
        Page<PostResponseDto> pages = postService.getPostsPages(id, page, pageSize);
        return ResponseEntity.ok().body(pages);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDto> updatePost(@RequestBody PostsDto post,@PathVariable Long id){
        PostResponseDto postToUpdate = postService.updatePost(post, id);
        return ResponseEntity.ok().body(postToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id){
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/countLikes")
    public ResponseEntity<Integer> countLikes(@PathVariable Long id){
        int postLikes = postService.countLikes(id);
        return ResponseEntity.ok().body(postLikes);
    }

    @GetMapping("/{id}/countComments")
    public ResponseEntity<Integer> countComments(@PathVariable Long id){
        int postComments = postService.countComments(id);
        return ResponseEntity.ok().body(postComments);
    }

}