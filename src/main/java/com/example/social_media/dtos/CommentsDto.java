package com.example.social_media.dtos;

import com.example.social_media.entities.Post;
import com.example.social_media.entities.User;

public class CommentsDto {
    private Long id;
    private String commentBody;
    private Post post;
    private User user;
    
    public CommentsDto(){}
    
    public CommentsDto(Long id, String commentBody, Post post, User user) {
        this.id = id;
        this.commentBody = commentBody;
        this.post = post;
        this.user = user;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getCommentBody() {
        return commentBody;
    }


    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }


    public Post getPost() {
        return post;
    }


    public void setPost(Post post) {
        this.post = post;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }

    
}