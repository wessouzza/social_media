package com.example.social_media.dtos;

import com.example.social_media.entities.Post;
import com.example.social_media.entities.User;

public class LikesDto {
    private Long id;
    private boolean liked;
    private Post post;
    private User user;
    
    public LikesDto(){}
    
    public LikesDto(Long id, boolean liked, Post post, User user) {
        this.id = id;
        this.liked = liked;
        this.post = post;
        this.user = user;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public boolean isLiked() {
        return liked;
    }


    public void setLiked(boolean liked) {
        this.liked = liked;
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