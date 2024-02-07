package com.example.programacion3.dto.Image;

public class ImageDTO {
    private String title;
    private String url;

    public ImageDTO() {
    }

    public ImageDTO(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
