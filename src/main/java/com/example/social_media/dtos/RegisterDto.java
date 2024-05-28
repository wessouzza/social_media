package com.example.social_media.dtos;

import java.util.ArrayList;
import java.util.List;

import com.example.social_media.entities.Post;

public class RegisterDto {

        private Long id;
        private String name;
        private String email;
        private String password;
        private List<Post> posts = new ArrayList<>();
    
        public RegisterDto(){}
    
        public RegisterDto(Long id, String name, String email, String password) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.password = password;
        }
    
        
        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public String getEmail() {
            return email;
        }
    
        public void setEmail(String email) {
            this.email = email;
        }
    
        public String getPassword() {
            return password;
        }
    
        public void setPassword(String password) {
            this.password = password;
        }
    
        public List<Post> getPosts() {
            return posts;
        }
    
        public void setPosts(List<Post> posts) {
            this.posts = posts;
        }
}