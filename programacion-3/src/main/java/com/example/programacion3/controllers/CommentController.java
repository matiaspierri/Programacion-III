package com.example.programacion3.controllers;

import com.example.programacion3.dto.Comment.CommentDTO;
import com.example.programacion3.models.Comment;
import com.example.programacion3.services.interfaces.ICommentService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/comment")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CommentController {
    @Autowired private ICommentService commentService;

    @PostMapping(value = "/{postId}")
    public Comment createComment(@RequestBody CommentDTO comment, @PathVariable Long postId){
        return this.commentService.createComment(comment.getText(), postId);
    }
    @GetMapping(value = "/{postId}")
    public Iterable<Comment> getCommentsByPostId(@PathVariable Long postId){
        return this.commentService.getCommentsByPostId(postId);
    }
}
