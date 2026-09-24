package com.dosideas.videojuegos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.dosideas.videojuegos.model.Videojuego;
import com.dosideas.videojuegos.service.VideojuegoService;

@Controller
public class ListadoController {

    @Autowired
    private VideojuegoService videojuegoService;

    @RequestMapping("/")
    public String listarVideojuegos(@RequestParam(required = false) String busqueda, Model model) {
        List<Videojuego> videojuegos = videojuegoService.buscarVideojuegos(busqueda);

        model.addAttribute("videojuegos", videojuegos);
        model.addAttribute("busqueda", busqueda);
        return "listado";
    }
}