package com.socialmedia.socialmediaApp.controllers;


import com.socialmedia.socialmediaApp.entities.Post;
import com.socialmedia.socialmediaApp.requests.PostCreateRequest;
import com.socialmedia.socialmediaApp.requests.PostUpdateRequest;
import com.socialmedia.socialmediaApp.responses.PostResponse;
import com.socialmedia.socialmediaApp.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostResponse> getAllPosts(@RequestParam Optional<Long> userId) {
        return postService.getAllPosts(userId);
    }

    @GetMapping("/{postId}")
    public Post getPost(@PathVariable Long postId) {
        return postService.getOnePostById(postId);
    }

    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest newPostRequest) {
        return postService.createOnePost(newPostRequest);
    }

    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId,@RequestBody PostUpdateRequest updatePost){
        return postService.updateOnePostById(postId,updatePost);
    }

    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId){
        postService.deleteOnePost(postId);
    }
}
