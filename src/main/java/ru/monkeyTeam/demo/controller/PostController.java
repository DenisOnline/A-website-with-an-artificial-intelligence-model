package ru.monkeyTeam.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.monkeyTeam.demo.models.Post;
import ru.monkeyTeam.demo.services.PostService;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/")
    public String posts(Model model) {
        model.addAttribute("posts", postService.listPost());
        return "posts";
    }

    @GetMapping("/post/create")
    public String pageCreatPost(Model model) {
        return "post_creat";
    }

    @PostMapping("/post/create")
    public String createPost(Post post) {
        postService.savePost(post);
        return "redirect:/";
    }

    @PostMapping("/post/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/";
    }

    @GetMapping("post/{id}")
    public String postInfo(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        return "post_info";
    }
}
