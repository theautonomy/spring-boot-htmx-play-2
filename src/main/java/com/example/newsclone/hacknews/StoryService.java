package com.example.newsclone.hacknews;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoryService {
    @Autowired private StoryRepository storyRepository;

    public List<Story> findAll() {
        return storyRepository.findAll();
    }

    public Story save(String title, String url) {
        return storyRepository.save(new Story(title, url));
    }
}
