package com.example.programacion3.services.interfaces;

import com.example.programacion3.models.Image;
import com.example.programacion3.models.Post;

public interface IImageService {
    Image createImage(Image image);
    Image createImage(String title, String url, Post post);
}
