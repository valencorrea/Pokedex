package com.certant.pokedexRefactorValen.pokemon.atributos.tipo.controller;

import com.certant.pokedexRefactorValen.pokemon.atributos.tipo.entity.Tipo;
import com.certant.pokedexRefactorValen.pokemon.atributos.tipo.service.ITipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/pokemon/tipo")
public class TipoController {
    @Autowired
    ITipoService tipoService;

    @GetMapping("/")
    public String findAll(Model model){
        List<Tipo> tipos = tipoService.findAll();
        model.addAttribute("title","Lista de tipos");
        model.addAttribute("tipos", tipos);
        return "tipo/findAll";
    }
}
