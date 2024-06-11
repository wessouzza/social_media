package com.example.social_media.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.example.social_media.dtos.CommentsDto;
import com.example.social_media.dtos.mapper.ModelMapper;
import com.example.social_media.dtos.responseDto.CommentResponseDto;
import com.example.social_media.dtos.responseDto.ResponseMapper;
import com.example.social_media.entities.Comments;
import com.example.social_media.entities.Post;
import com.example.social_media.exceptions.CommentNotFoundException;
import com.example.social_media.exceptions.PostNotFoundException;
import com.example.social_media.repositories.CommentRepository;
import com.example.social_media.repositories.PostRepository;


@Service 
public class CommentService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;


    public CommentResponseDto createComment(CommentsDto comment, long id){
        CommentsDto newComment = new CommentsDto();
        Post post = postRepository.findById(id)
            .orElseThrow(()-> new PostNotFoundException("Post not found."));

        newComment.setCommentBody(comment.getCommentBody());
        newComment.setUser(comment.getUser());
        newComment.setPost(post);
        post.getComments().add(ModelMapper.toComment(newComment));
        postRepository.save(post);

        return  ResponseMapper.toCommentResponseDto(commentRepository.save(ModelMapper.toComment(newComment)));
    }

    public List<CommentResponseDto> getCommentsByPost(long id){
        Post posts = postRepository.findById(id)
            .orElseThrow(()-> new PostNotFoundException("Post not found."));
        
        List<CommentResponseDto> cDtos = posts.getComments()
            .stream().map(ResponseMapper::toCommentResponseDto).collect(Collectors.toList());
        return cDtos;
    }

    public Page<CommentResponseDto> getCommentPageable(Long id, int page, int pageSize){
        Post post = postRepository.findById(id).orElseThrow(()-> new PostNotFoundException("Post not found"));
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC, "id"));
        Page<Comments> comment = commentRepository.findByPost(post, pageable);
        List<CommentResponseDto> commentsResponse = comment.stream().map(ResponseMapper::toCommentResponseDto)
                .collect(Collectors.toList());
        return new PageImpl<>(commentsResponse, pageable, comment.getTotalElements());
    }

    public List<CommentsDto> getAll(){
        List<CommentsDto> cDto = commentRepository.findAll()
            .stream().map(ModelMapper::toCommentsDto).collect(Collectors.toList());
        return cDto;
    }

    public CommentResponseDto updateComment(CommentsDto comment, Long id){
        Comments commentUpdate = commentRepository.findById(id)
            .orElseThrow(()-> new CommentNotFoundException("Comment not found."));
        commentUpdate.setCommentBody(comment.getCommentBody());
        commentRepository.save(commentUpdate);

        return ResponseMapper.toCommentResponseDto(commentUpdate);
    }

    public void deleteComment(Long id){
        Comments comment = commentRepository.findById(id)
            .orElseThrow(()-> new CommentNotFoundException("Comment not found."));
        commentRepository.delete(comment);
    }
}