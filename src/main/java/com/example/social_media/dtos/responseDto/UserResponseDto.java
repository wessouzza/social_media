package com.example.social_media.dtos.responseDto;

public class UserResponseDto{
    private long id;
    private String name;

    public UserResponseDto(){}

    public UserResponseDto(long id, String name){
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}