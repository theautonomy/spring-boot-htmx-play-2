package com.example.newsclone.instagram;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByUser(User user);
}
