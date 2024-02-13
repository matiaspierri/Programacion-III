package com.example.programacion3.services;

import com.example.programacion3.models.Image;
import com.example.programacion3.models.Post;
import com.example.programacion3.repositories.ImageRepository;
import com.example.programacion3.services.interfaces.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class ImageServiceImpl implements IImageService {
    @Autowired
    private ImageRepository imageRepository;

    List<String> images = new ArrayList<>(Arrays.asList(
            "https://images.unsplash.com/photo-1494790108377-be9c29b29330?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1679679008383-6f778fe07828?q=80&w=2127&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://plus.unsplash.com/premium_photo-1665941065977-993d9105662a?q=80&w=1972&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1513682121497-80211f36a7d3?q=80&w=1976&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1517841905240-472988babdf9?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1539571696357-5a69c17a67c6?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://plus.unsplash.com/premium_photo-1665941065957-8c350dee9f82?q=80&w=1972&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://plus.unsplash.com/premium_photo-1682681907111-c13bc10b1587?q=80&w=1976&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1524504388940-b1c1722653e1?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://plus.unsplash.com/premium_photo-1670588776057-cf5cd890fb98?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1696446701796-da61225697cc?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1513171920216-2640b288471b?q=80&w=1709&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    ));
    List<String> titles = new ArrayList<>(Arrays.asList(
            "Fotografía de primer plano de la mujer sonriendo",
            "una persona montando una tabla en un cuerpo de agua",
            "Un hombre con rastas de pie junto a una niña pequeña",
            "Personas que caminan por el carril peatonal",
            "Mujer de pie cerca de la puerta de acero azul",
            "Hombre de pie cerca de la pared blanca",
            "Un par de niños que están parados en la hierba",
            "hombre con camisa blanca con cuello en V",
            "Un grupo de personas de pie alrededor de una piscina",
            "mujer sosteniendo el pelo rubio largo y pesado",
            "Un hombre y una mujer posando para una foto",
            "Dos mujeres sentadas una al lado de la otra sosteniendo una botella",
            "Fotografía de vista aérea de un grupo de personas que caminan por un carril peatonal gris y blanco"
    ));

    public String getImage(int index){
        return images.get(index);
    }

    public String getTitle(int index){
        return titles.get(index);
    }


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

    @Override
    @Transactional
    public Image createImage(Post post) {
        Random random = new Random();
        int index = random.nextInt(images.size());
        return this.imageRepository.save(new Image(getTitle(index), getImage(index), post));
    }

    @Override
    @Transactional
    public void deleteImagesByPost(Post post) {
        this.imageRepository.deleteAllByPost(post);
    }
}
