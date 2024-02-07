package com.example.programacion3.dto.Post;

import com.example.programacion3.dto.Image.ImageDTO;

import java.util.List;

public class PostDTO {
    private String description;
    private List<ImageDTO> images;

    public PostDTO() {
    }

    public PostDTO(String description, List<ImageDTO> images) {
        this.description = description;
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public List<ImageDTO> getImages() {
        return images;
    }
}
