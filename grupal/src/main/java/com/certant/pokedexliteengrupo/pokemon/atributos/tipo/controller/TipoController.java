package com.certant.pokedexliteengrupo.pokemon.atributos.tipo.controller;

import com.certant.pokedexliteengrupo.pokemon.atributos.tipo.entity.Tipo;
import com.certant.pokedexliteengrupo.pokemon.atributos.tipo.service.TipoService;
import com.certant.pokedexliteengrupo.pokemon.entity.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tipo")
public class TipoController {

    @Autowired
    TipoService tipoService;
    @GetMapping("/")
    public String findAll(Model model){
        List<Tipo> tipos = tipoService.findAll();
        model.addAttribute("title","Lista de tipos");
        model.addAttribute("tipos", tipos);
        return "tipo/findAll";
    }
}
