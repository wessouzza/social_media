package com.example.social_media.dtos.responseDto;

import java.time.LocalDateTime;

public class PostResponseDto{
    private long id;
    private String body;
    private LocalDateTime publicationDate;
    
    public PostResponseDto(){}

    public PostResponseDto(long id, String body, LocalDateTime publicationDate){
        this.id = id;
        this.body = body;
        this.publicationDate = publicationDate;
    }


    
    public long getId() {
        return id;
    }

    public void setId(long id) {
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


}