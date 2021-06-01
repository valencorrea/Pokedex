package com.certant.pokedexRefactorValen.pokemon.controlador;

import com.certant.pokedexRefactorValen.pokemon.entidad.Pokemon;
import com.certant.pokedexRefactorValen.pokemon.servicio.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
// lo que ingreso en la url localhost
@RequestMapping("/pokemon")
public class PokemonControlador {

    @Autowired
    // instancio el repositorio de pokemones de la base de datos
    private IPokemonService pokemonDao;

    @GetMapping("/")
    public String inicio(Model model){

        // pokemones es la variable que trato desde el .html
        List<Pokemon> pokemones = pokemonDao.findAll();

        model.addAttribute("title","Pokemones en base de datos");
        model.addAttribute("pokemones", pokemones);

        // va al archivo .html dentro de resources
        return "pokemon/findAll";

    }

}


