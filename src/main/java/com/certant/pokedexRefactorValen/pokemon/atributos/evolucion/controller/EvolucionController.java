package com.certant.pokedexRefactorValen.pokemon.atributos.evolucion.controller;

import com.certant.pokedexRefactorValen.pokemon.atributos.evolucion.entity.Evolucion;
import com.certant.pokedexRefactorValen.pokemon.atributos.evolucion.service.IEvolucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/pokemon/evolucion")
public class EvolucionController {
    @Autowired
    IEvolucionService evolucionService;

    @GetMapping("/")
    public String findAll(Model model){
        List<Evolucion> evoluciones = evolucionService.findAll();
        model.addAttribute("title","Lista de evoluciones");
        model.addAttribute("evoluciones", evoluciones);
        return "evolucion/findAll";
    }
}/*probando las ramas*/