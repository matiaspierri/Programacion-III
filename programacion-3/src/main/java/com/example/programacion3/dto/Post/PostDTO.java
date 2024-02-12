package com.example.programacion3.dto.Post;

import com.example.programacion3.dto.Image.ImageDTO;

import java.util.List;

public class PostDTO {
    private String title;
    private String content;
    private List<ImageDTO> images;

    public PostDTO() {
    }

    public PostDTO(String title, String content, List<ImageDTO> images) {
        this.title = title;
        this.content = content;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<ImageDTO> getImages() {
        return images;
    }
}
