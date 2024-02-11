package com.example.programacion3.dto.Post;

import com.example.programacion3.dto.Image.ImageDTO;

import java.util.List;

public class PostDTO {
    private String title;
    private String description;
    private List<ImageDTO> images;

    public PostDTO() {
    }

    public PostDTO(String title, String description, List<ImageDTO> images) {
        this.title = title;
        this.description = description;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<ImageDTO> getImages() {
        return images;
    }
}
