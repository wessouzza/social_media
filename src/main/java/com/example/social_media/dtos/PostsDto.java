package com.example.social_media.dtos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.social_media.entities.Comments;
import com.example.social_media.entities.Likes;
import com.example.social_media.entities.User;

public class PostsDto {
    private Long id;
    private String body;
    private LocalDateTime publicationDate;
    private User user;
    
    public PostsDto(){}
    
    public PostsDto(Long id, String body, LocalDateTime publicationDate) {
        this.id = id;
        this.body = body;
        this.publicationDate = publicationDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}