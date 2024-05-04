package com.socialmedia.socialmediaApp.controllers;

import com.socialmedia.socialmediaApp.entities.Comment;
import com.socialmedia.socialmediaApp.requests.CommentCreateRequest;
import com.socialmedia.socialmediaApp.requests.CommentUpdateRequest;
import com.socialmedia.socialmediaApp.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getComments(@RequestParam Optional<Long> userId,@RequestParam Optional<Long> postId) {
        return commentService.getAllCommentsWithParam(userId,postId);
    }

    @GetMapping("/{commentId}")
    public Comment getOneComment(@PathVariable Long commentId) {
        return commentService.getOneCommentById(commentId);
    }

    @PostMapping
    public Comment createComment(@RequestBody CommentCreateRequest request) {
        return commentService.createOneComment(request);
    }

    @PutMapping("/{commentId}")
    public Comment updateComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest request) {
        return commentService.updateOneCommentById(commentId,request);
    }

    @DeleteMapping("/{commentId}")
    public void deleteOneComment(@PathVariable Long commentId) {
        commentService.deleteCommentById(commentId);
    }
}
