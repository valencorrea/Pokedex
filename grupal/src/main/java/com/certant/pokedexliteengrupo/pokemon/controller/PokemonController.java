package com.certant.pokedexliteengrupo.pokemon.controller;

import com.certant.pokedexliteengrupo.pokemon.atributos.evolucionaa.entity.EvolucionaA;
import com.certant.pokedexliteengrupo.pokemon.atributos.evolucionaa.service.IEvolucionaAService;
import com.certant.pokedexliteengrupo.pokemon.atributos.habilidad.entity.Habilidad;
import com.certant.pokedexliteengrupo.pokemon.atributos.habilidad.service.IHabilidadService;
import com.certant.pokedexliteengrupo.pokemon.atributos.tipo.entity.Tipo;
import com.certant.pokedexliteengrupo.pokemon.atributos.tipo.service.ITipoService;
import com.certant.pokedexliteengrupo.pokemon.entity.Pokemon;
import com.certant.pokedexliteengrupo.pokemon.exception.PokemonInvalidPointerException;
import com.certant.pokedexliteengrupo.pokemon.service.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    IPokemonService pokemonService;

    @Autowired
    IHabilidadService habilidadService;

    @Autowired
    ITipoService tipoService;

    @GetMapping({"/",""})
    public String findAll(Model model){
        List<Pokemon> pokemones = pokemonService.findAll();
        model.addAttribute("title","Lista de pokemones");
        model.addAttribute("pokemones", pokemones);
        return "pokemon/findAll";
    }

    @GetMapping("/agregar")
    public String addPokemon(Model model){
        Pokemon pokemon = new Pokemon();
        List<Habilidad> habilidades = habilidadService.findAll();
        List<Tipo> tipos = tipoService.findAll();
        model.addAttribute("title", "Agregar un nuevo pokemon");
        model.addAttribute("pokemon",pokemon);
        model.addAttribute("todosTipos",tipos);
        model.addAttribute("todasHabilidades",habilidades);
        return "pokemon/addPokemon";
    }

    @PostMapping("/agregar")
    public  String guardarPokemon(Pokemon pokemon) throws PokemonInvalidPointerException {
        pokemonService.save(pokemon);
        return "redirect:/pokemon";
    }


}
