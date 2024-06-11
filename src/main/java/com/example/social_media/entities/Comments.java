package com.example.social_media.entities;

import java.io.Serializable;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_comments")
public class Comments implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String commentBody;
    @ManyToOne
    private Post post;
    @ManyToOne
    private User user;

    public Comments(){}

    public Comments(Long id, String commentBody, Post post, User user) {
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