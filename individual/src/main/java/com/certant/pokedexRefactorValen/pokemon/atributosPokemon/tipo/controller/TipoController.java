package com.certant.pokedexRefactorValen.pokemon.atributosPokemon.tipo.controller;

import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.tipo.entity.Tipo;
import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.tipo.service.ITipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/pokemon/tipo")
public class TipoController {
    @Autowired
    ITipoService tipoService;

    @ResponseBody
    @GetMapping("/")
    //public String findAll(Model model){
    public List<Tipo> findAll(Model model){
        List<Tipo> tipos = tipoService.findAll();
        model.addAttribute("title","Lista de tipos");
        model.addAttribute("tipos", tipos);
        //return "tipo/findAll";
        return tipos;
    }
}
