package com.example.demo.controller;

import com.example.demo.model.post;
import com.example.demo.services.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private Post postService;

    @GetMapping
    public List<post> getPosts(){
        return postService.listPosts();
    }

    @GetMapping("/user/{userId}")
    public List<post> getUserPosts(@PathVariable Long userId){
        return postService.ListUserPosts(userId);
    }

    @PostMapping("/user/{userId}")
    public post createPost(@PathVariable Long userId, @RequestBody post postData){
        return postService.createPost(userId,postData);
    }

    @PatchMapping("/{postId}")
    public post UpdatePost(@PathVariable Long postId, post updatedData){
        return postService.updatePost(postId,updatedData);
    }

    @PutMapping("/{postId}/like")
    public post likePost(@PathVariable Long postId){
        return postService.likePost(postId);
    }

    @PutMapping("/{postId}/dislike")
    public post DislikePost(@PathVariable Long postId){
        return postService.DislikePost(postId);
    }

    @PutMapping("/{postId}/share")
    public post SharePost(@PathVariable Long postId){
        return postService.sharePost(postId);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId){
        postService.deletePost(postId);
    }
}
