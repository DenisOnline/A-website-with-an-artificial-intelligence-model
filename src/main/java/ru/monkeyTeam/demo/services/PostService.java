package ru.monkeyTeam.demo.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.objenesis.SpringObjenesis;
import org.springframework.stereotype.Service;
import ru.monkeyTeam.demo.models.Post;
import ru.monkeyTeam.demo.repositories.PostRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Iterable<Post> listPost() {
        return postRepository.findAll();
    }

    public void savePost(Post post) {
        log.info("Saving new {}" , post);
        postRepository.save(post);
    }

    public void deletePost(Long id) {
        log.info("Delete post {}" , postRepository.findById(id));
        postRepository.deleteById(id);
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }
}
