package com.dosideas.videojuegos.repository;

import com.dosideas.videojuegos.model.Videojuego;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {
    List<Videojuego> findByTituloContainingIgnoreCase(String titulo);
}