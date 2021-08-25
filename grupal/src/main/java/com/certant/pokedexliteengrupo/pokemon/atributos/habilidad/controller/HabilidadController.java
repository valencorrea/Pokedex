package com.certant.pokedexliteengrupo.pokemon.atributos.habilidad.controller;

import com.certant.pokedexliteengrupo.pokemon.atributos.habilidad.entity.Habilidad;
import com.certant.pokedexliteengrupo.pokemon.atributos.habilidad.service.IHabilidadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/habilidad")
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
