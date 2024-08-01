package com.example.social_media.dtos.mapper;

import com.example.social_media.dtos.CommentsDto;
import com.example.social_media.dtos.LikesDto;
import com.example.social_media.dtos.PostsDto;
import com.example.social_media.dtos.UserDto;
import com.example.social_media.dtos.responseDto.UserResponseDto;
import com.example.social_media.entities.Comments;
import com.example.social_media.entities.Likes;
import com.example.social_media.entities.Post;
import com.example.social_media.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public class ModelMapper {
    public static UserDto toUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPosts(user.getPosts());

        return userDto;
    }

    public static User toUser(UserDto userDto){

        if(userDto == null){
            return null;
        }

        User user = new User();
        if(user.getId() != null){
            user.setId(userDto.getId());
        }
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPosts(userDto.getPosts());
        
        return user;
    }


    public static PostsDto toPostDto(Post post){
        if(post == null){
            return null;
        }

        PostsDto postsDto = new PostsDto();
        postsDto.setId(post.getId());
        postsDto.setBody(post.getBody());
        postsDto.setPublicationDate(post.getPublicationDate());
        postsDto.setUser(post.getUser());
        //postsDto.setComments(post.getComments());
        //postsDto.setLikes(post.getLikes());

        return postsDto;
    }

    public static Post toPost(PostsDto postsDto){

        Post post = new Post();
        post.setId(postsDto.getId());
        post.setBody(postsDto.getBody());
        post.setPublicationDate(postsDto.getPublicationDate());
        post.setUser(postsDto.getUser());
        //post.setComments(postsDto.getComments());
        //post.setLikes(postsDto.getLikes());

        return post;
    }


    public static CommentsDto toCommentsDto(Comments comments){
        CommentsDto commentsDto = new CommentsDto();
        commentsDto.setId(comments.getId());
        commentsDto.setCommentBody(comments.getCommentBody());
        commentsDto.setPost(comments.getPost());
        commentsDto.setUser(comments.getUser());

        return commentsDto;
    }

    public static Comments toComment(CommentsDto commentsDto){
        Comments comments = new Comments();
        comments.setId(commentsDto.getId());
        comments.setCommentBody(commentsDto.getCommentBody());
        comments.setPost(commentsDto.getPost());
        comments.setUser(commentsDto.getUser());

        return comments;
    }


    public static LikesDto toLikesDto(Likes likes){
        LikesDto likesDto = new LikesDto();
        likesDto.setId(likes.getId());
        likesDto.setLiked(likes.isLiked());
        likesDto.setPost(likes.getPost());
        likesDto.setUser(likes.getUser());

        return likesDto;
    }
    
}