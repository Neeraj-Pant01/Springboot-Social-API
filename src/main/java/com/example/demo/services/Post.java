package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.model.post;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Post {

    @Autowired
    private PostRepository postrepository;

    @Autowired
    private UserRepository userrepository;

    public List<post> listPosts() {
        return postrepository.findAll();
    }

    public List<post> ListUserPosts(Long userId) {
        return postrepository.findByUserId(userId);
    }

    public post createPost(Long userId, post postData) {
        User user = userrepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
        postData.setUser(user);
        return postrepository.save(postData);
    }

    public post getSinglePost(Long postId) {
        return postrepository.findById(postId).orElse(null);
    }

    public post updatePost(Long postId, post updatedPostdata) {
        post currentPost = postrepository.findById(postId).orElseThrow(() -> new RuntimeException("post not found"));
        currentPost.setTitle(updatedPostdata.getTitle());
        currentPost.setDescription(updatedPostdata.getDescription());
        currentPost.setImageUrl(updatedPostdata.getImageUrl());
        return postrepository.save(currentPost);
    }

    public void deletePost(Long postId) {
        postrepository.deleteById(postId);
    }

    public post likePost(Long postId) {
        post currentPost = postrepository.findById(postId).orElseThrow(() -> new RuntimeException("post not found !"));
        currentPost.setLikes(currentPost.getLikes() + 1);
        return postrepository.save(currentPost);
    }

    public post DislikePost(Long postId) {
        post currentPost = postrepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found !"));
        currentPost.setDisLikes(currentPost.getDislikes() + 1);
        currentPost.setLikes((currentPost.getLikes() >= 0) ? currentPost.getLikes() - 1 : 0);
        return postrepository.save(currentPost);

    }

    public post sharePost(Long postId){
        post currentPost = postrepository.findById(postId).orElseThrow(()-> new RuntimeException("Post not found !"));
        currentPost.setShares(currentPost.getShares() + 1);
        return postrepository.save(currentPost);
    }
}


