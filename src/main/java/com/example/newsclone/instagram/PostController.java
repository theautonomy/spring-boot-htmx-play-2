package com.example.newsclone.instagram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @Autowired private PostService postService;

    @Autowired private UserService userService;

    @GetMapping("/instagram")
    public String index(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "instagram";
    }

    @PostMapping("/instagram/add")
    public String addPost(
            @RequestParam String caption, @RequestParam String username, Model model) {
        User user = userService.findByUsername(username);
        Post post = new Post();
        post.setCaption(caption);
        post.setUser(user);
        postService.savePost(post);
        model.addAttribute("posts", postService.findAll());
        return "fragments/post-list::postList";
    }
}
