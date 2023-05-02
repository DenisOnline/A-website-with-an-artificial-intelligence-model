package ru.monkeyTeam.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.monkeyTeam.demo.models.Image;
import ru.monkeyTeam.demo.models.ImageDto;
import ru.monkeyTeam.demo.models.Post;
import ru.monkeyTeam.demo.services.PostService;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/")
    public String posts(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("posts", postService.listPost(title));
        return "posts";
    }

    @GetMapping("/post/creat")
    public String pageCreatPost(Model model) {
        return "post_creat";
    }

    @PostMapping("/post/creat")
    public String createPost(@RequestParam("file") MultipartFile file, Post post) throws IOException {
        postService.savePost(post, file);
        return "redirect:/";
    }

    @PostMapping("/post/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/";
    }

    @GetMapping("post/{id}")
    public String postInfo(@PathVariable Long id, Model model) {
        Post post = postService.getPostById(id);
        List<ImageDto> images = postService.listImagesDtos(post);
        model.addAttribute("post", post);
        model.addAttribute("images", images);
        return "post_info";
    }
}
