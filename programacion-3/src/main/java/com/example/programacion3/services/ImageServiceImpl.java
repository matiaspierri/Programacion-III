package com.example.programacion3.services;

import com.example.programacion3.models.Image;
import com.example.programacion3.models.Post;
import com.example.programacion3.repositories.ImageRepository;
import com.example.programacion3.services.interfaces.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ImageServiceImpl implements IImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    @Transactional
    public Image createImage(Image image) {
        return this.imageRepository.save(image);
    }

    @Override
    @Transactional
    public Image createImage(String title, String url, Post post) {
        return this.imageRepository.save(new Image(title, url, post));
    }
}
