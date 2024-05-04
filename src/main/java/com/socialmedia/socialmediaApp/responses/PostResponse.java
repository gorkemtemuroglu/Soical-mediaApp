package com.socialmedia.socialmediaApp.responses;

import com.socialmedia.socialmediaApp.entities.Like;
import com.socialmedia.socialmediaApp.entities.Post;
import lombok.Data;

import java.util.List;

@Data
public class PostResponse {

    Long id;
    Long userId;
    String userName;
    String title;
    String text;
    List<LikeResponse> postLikes;

    // Constructor base mapper
    public PostResponse(Post entity, List<LikeResponse> postLikes) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.userName = entity.getUser().getUserName();
        this.title = entity.getTitle();
        this.text = entity.getText();
        this.postLikes = postLikes;
    }
}
