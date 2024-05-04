package com.socialmedia.socialmediaApp.services;

import com.socialmedia.socialmediaApp.entities.Like;
import com.socialmedia.socialmediaApp.entities.Post;
import com.socialmedia.socialmediaApp.entities.User;
import com.socialmedia.socialmediaApp.repos.PostRepository;
import com.socialmedia.socialmediaApp.requests.PostCreateRequest;
import com.socialmedia.socialmediaApp.requests.PostUpdateRequest;
import com.socialmedia.socialmediaApp.responses.LikeResponse;
import com.socialmedia.socialmediaApp.responses.PostResponse;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;
    @Setter
    private LikeService likeService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;

    }


    public List<PostResponse> getAllPosts(Optional<Long> userId) {
        List<Post> list;
        if(userId.isPresent()) {
            list=  postRepository.findByUserId(userId.get());
        } else{

        list= postRepository.findAll();
        }

        return list.stream().map((p)-> {
            List<LikeResponse> likes =  likeService.getAllLikesWithParam(null,Optional.of(p.getId()));

            return new PostResponse(p,likes);
        }).collect(Collectors.toList());

    }

    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post createOnePost(PostCreateRequest newPostRequest) {
        User user= userService.getOneUserById(newPostRequest.getUserId());
        if(user==null){
            return null;
        }
        Post toSave = new Post();
        toSave.setId(newPostRequest.getId());
        toSave.setTitle(newPostRequest.getTitle());
        toSave.setText(newPostRequest.getText());
        toSave.setUser(user);
        return postRepository.save(toSave);
    }

    public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) {
        Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()){
            Post toUpdate = post.get();
            toUpdate.setText(updatePost.getText());
            toUpdate.setTitle(updatePost.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;
        }

        return null;
    }

    public void deleteOnePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
