package com.example.newsclone.instagram;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired private PostRepository postRepository;

    public List<Post> findAllByUser(User user) {
        return postRepository.findAllByUser(user);
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
