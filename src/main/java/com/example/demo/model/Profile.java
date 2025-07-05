package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;
    private String phone;

    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    public  Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getBio(){
        return bio;
    }
    public void setBio(String bio){
        this.bio = bio;
    }

    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }

    public User getUser(){
        return  user;
    }
    public void setUser(User user){
        this.user = user;
    }


}
