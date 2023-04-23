package ru.monkeyTeam.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.monkeyTeam.demo.models.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitle(String title);
}
