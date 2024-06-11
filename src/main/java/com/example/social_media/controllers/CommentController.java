package com.example.social_media.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.social_media.dtos.CommentsDto;
import com.example.social_media.dtos.responseDto.CommentResponseDto;
import com.example.social_media.services.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController{
    @Autowired
    private CommentService commentService;

    @PostMapping("/posts/{id}")
    public ResponseEntity<CommentResponseDto> createComment(@RequestBody CommentsDto comment, @PathVariable Long id){
        CommentResponseDto newComment = commentService.createComment(comment, id);
        return ResponseEntity.ok().body(newComment);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<List<CommentResponseDto>> getCommentByPost(@PathVariable long id){
        List<CommentResponseDto> cDtos = commentService.getCommentsByPost(id);
        return ResponseEntity.ok().body(cDtos);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Page<CommentResponseDto>> getCommentPageable(@PathVariable Long id, @RequestParam int page,
                                                                       @RequestParam int pageSize){
        Page<CommentResponseDto> comments = commentService.getCommentPageable(id, page, pageSize);
        return ResponseEntity.ok().body(comments);
    }

    @GetMapping
    public ResponseEntity<List<CommentsDto>> findAll(){
        List<CommentsDto> commentsDtos = commentService.getAll();
        return ResponseEntity.ok().body(commentsDtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentResponseDto> updateComment(@RequestBody CommentsDto comment, @PathVariable Long id){
        CommentResponseDto commentUpdate = commentService.updateComment(comment, id);
        return ResponseEntity.ok().body(commentUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id){
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}