package com.certant.pokedexRefactorValen.pokemon.atributos.habilidad.controller;

import com.certant.pokedexRefactorValen.pokemon.atributos.habilidad.entity.Habilidad;
import com.certant.pokedexRefactorValen.pokemon.atributos.habilidad.service.IHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/pokemon/habilidad")
public class HabilidadController {
    @Autowired
    IHabilidadService habilidadService;

    @GetMapping("/")
    public String findAll(Model model){
        List<Habilidad> habilidades = habilidadService.findAll();
        model.addAttribute("title","Lista de habilidades");
        model.addAttribute("habilidades", habilidades);
        return "habilidad/findAll";
    }
}
