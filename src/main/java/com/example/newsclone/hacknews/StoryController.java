package com.example.newsclone.hacknews;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StoryController {

    @Autowired private StoryService storyService;

    @GetMapping("/hacknews")
    public String index(Model model) {
        List<Story> stories = storyService.findAll();
        model.addAttribute("stories", stories);
        return "hacknews";
    }

    @PostMapping("/hacknews/add")
    public String addStory(@RequestParam String title, @RequestParam String url, Model model) {
        storyService.save(title, url);
        List<Story> stories = storyService.findAll();
        model.addAttribute("stories", stories);
        return "fragments/story-list::storyList";
    }
}
