package com.dosideas.videojuegos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dosideas.videojuegos.model.Videojuego;
import com.dosideas.videojuegos.repository.VideojuegoRepository;

@Service
public class VideojuegoService {

    @Autowired
    private VideojuegoRepository videojuegoRepository;

    public List<Videojuego> buscarVideojuegos(String busqueda) {
        if (busqueda != null && !busqueda.isEmpty()) {
            return videojuegoRepository.findByTituloContainingIgnoreCase(busqueda);
        }
        return videojuegoRepository.findAll();
    }
}