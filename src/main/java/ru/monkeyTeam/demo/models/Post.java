package ru.monkeyTeam.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @Column(name = "imageId")
//    private Long imageId;
    @Column(name = "title")
    private String title;
    @Column(name = "description", columnDefinition = "text")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "post")
    private List<Image> images = new ArrayList<>();
    private LocalDateTime dateTime;
    @PrePersist
    private void init() {
        dateTime = LocalDateTime.now();
    }
    public void addImageToPost(Image image) {
        image.setPost(this);
        images.add(image);
    }

    public List<Image> getImages(){
        return images;
    }
}
