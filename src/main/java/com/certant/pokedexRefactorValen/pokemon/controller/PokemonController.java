package com.certant.pokedexRefactorValen.pokemon.controller;

import com.certant.pokedexRefactorValen.pokemon.entity.Pokemon;
import com.certant.pokedexRefactorValen.pokemon.service.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    IPokemonService pokemonService;

    @GetMapping("/")
    public String findAll(Model model){
        List<Pokemon> pokemones = pokemonService.findAll();
        model.addAttribute("title","Lista de pokemones");
        model.addAttribute("pokemones", pokemones);
        return "pokemon/findAll";
    }
}
