package com.example.social_media.dtos.responseDto;

import com.example.social_media.entities.Comments;
import com.example.social_media.entities.Likes;
import com.example.social_media.entities.Post;
import com.example.social_media.entities.User;

public class ResponseMapper {
    
    public static UserResponseDto toUserResponseDto(User user){
        UserResponseDto userDto = new UserResponseDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());

        return userDto;    
    }

    public static User toUser(UserResponseDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());

        return user;
    }   
    
    
    public static PostResponseDto toPostResponseDto(Post post){
        PostResponseDto postDto = new PostResponseDto();
        postDto.setId(post.getId());
        postDto.setBody(post.getBody());
        postDto.setPublicationDate(post.getPublicationDate());

        return postDto;
    }

   /*   public static Post toPost(PostResponseDto postDto){
        Post post = new Post();
        post.setBody(postDto.getBody());
        post.setPublicationDate(postDto.getPublicationDate());

        return post;
    } */  
    
    
    public static CommentResponseDto toCommentResponseDto(Comments comment){
        CommentResponseDto commentDto = new CommentResponseDto();
        commentDto.setId(comment.getId());
        commentDto.setCommentBody(comment.getCommentBody());
        commentDto.setCommentAuthor(comment.getUser().getName());

        return commentDto;
    } 
    
    
    public static LikeResponseDto toLikeResponseDto(Likes likes){
        LikeResponseDto likeDto = new LikeResponseDto();
        likeDto.setId(likes.getId());
        likeDto.setLikedBy(likes.getUser().getName());

        return likeDto;
    }

  
    
}