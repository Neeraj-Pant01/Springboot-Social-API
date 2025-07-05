package com.example.demo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="posts")
public class post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String imageUrl;

    private int likes;
    private int dislikes;
    private int shares;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonBackReference
    private User user;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
         this.id = id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public String getImageUrl(){
        return  imageUrl;
    }
    public  void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    public int getLikes(){
        return likes;
    }
    public void setLikes(int likes){
        this.likes = likes;
    }

    public int getDislikes(){
        return  dislikes;
    }
    public void setDisLikes(int dislikes){
        this.dislikes = dislikes;
    }

    public int getShares(){
        return shares;
    }
    public void setShares(int shares){
        this.shares = shares;
    }

    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }

}
