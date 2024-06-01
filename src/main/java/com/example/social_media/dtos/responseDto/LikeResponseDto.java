package com.example.social_media.dtos.responseDto;

public class LikeResponseDto {
    private long id;
    private String likedBy;

    public LikeResponseDto(){}

    public LikeResponseDto(long id, String likedBy) {
        this.id = id;
        this.likedBy = likedBy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLikedBy() {
        return likedBy;
    }

    public void setLikedBy(String likedBy) {
        this.likedBy = likedBy;
    }
}