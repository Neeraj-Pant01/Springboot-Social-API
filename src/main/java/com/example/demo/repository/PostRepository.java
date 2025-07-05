package com.example.demo.repository;

import com.example.demo.model.post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository <post , Long> {
    List <post> findByUserId(Long userId);
}
