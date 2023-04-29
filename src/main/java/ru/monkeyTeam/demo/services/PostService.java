package ru.monkeyTeam.demo.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.monkeyTeam.demo.models.Image;
import ru.monkeyTeam.demo.models.Post;
import ru.monkeyTeam.demo.repositories.PostRepository;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> listPost(String title) {
        if (title != null) {
            return postRepository.findByTitle(title);
        }
        return postRepository.findAll();
    }

    public void savePost(Post post, MultipartFile file) throws IOException {
        Image image = new Image();
        if (!file.isEmpty()) {
            image.setName(file.getName());
            image.setOriginalFileName(file.getOriginalFilename());
            image.setContentType(file.getContentType());
            image.setSize(String.valueOf(file.getSize()));
            image.setBytes(file.getBytes());
            post.addImageToPost(image);
        }
        log.info("Saving new Post. Title: {}" , post.getTitle());
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
