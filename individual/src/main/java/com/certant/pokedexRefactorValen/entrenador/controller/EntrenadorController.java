package com.certant.pokedexRefactorValen.entrenador.controller;

import com.certant.pokedexRefactorValen.entrenador.entity.Entrenador;
import com.certant.pokedexRefactorValen.entrenador.service.IEntrenadorService;
import com.certant.pokedexRefactorValen.pokemon.entity.Pokemon;
import com.certant.pokedexRefactorValen.pokemon.service.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/entrenador")
public class EntrenadorController {

    @Autowired
    IEntrenadorService entrenadorService;

    @GetMapping("/")
    public String findAll(Model model) {
        List<Entrenador> entrenadores = entrenadorService.findAll();
        model.addAttribute("title", "Lista de entrenadores");
        model.addAttribute("entrenadores", entrenadores);
        return "entrenador/findAll";
    }
}