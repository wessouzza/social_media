package com.example.social_media.dtos.responseDto;

public class CommentResponseDto {
    private long id;
    private String commentBody;
    private String commentAuthor;

    public CommentResponseDto(){}
    
    public CommentResponseDto(long id, String commentBody, String commentAuthor) {
        this.id = id;
        this.commentBody = commentBody;
        this.commentAuthor = commentAuthor;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    

    
}