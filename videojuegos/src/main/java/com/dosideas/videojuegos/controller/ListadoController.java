package com.dosideas.videojuegos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.dosideas.videojuegos.Videojuego;
import com.dosideas.videojuegos.VideojuegoRepository;

@Controller
public class ListadoController {

    @Autowired
    private VideojuegoRepository videojuegoRepository;

    @RequestMapping("/")
    public String listarVideojuegos(@RequestParam(required = false) String busqueda, Model model) {
        List<Videojuego> videojuegos;

        if (busqueda != null && !busqueda.isEmpty()) {
            videojuegos = videojuegoRepository.findByTituloContainingIgnoreCase(busqueda);
        } else {
            videojuegos = videojuegoRepository.findAll();
        }

        model.addAttribute("videojuegos", videojuegos);
        model.addAttribute("busqueda", busqueda);
        return "listado";
    }
}