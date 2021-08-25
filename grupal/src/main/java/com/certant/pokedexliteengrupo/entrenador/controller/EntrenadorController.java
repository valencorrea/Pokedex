package com.certant.pokedexliteengrupo.entrenador.controller;

import com.certant.pokedexliteengrupo.entrenador.entity.Entrenador;
import com.certant.pokedexliteengrupo.entrenador.exception.EntrenadorNotFoundException;
import com.certant.pokedexliteengrupo.entrenador.service.IEntrenadorService;
import com.certant.pokedexliteengrupo.pokemon.atributos.pokemonenentrenamiento.entity.PokemonEnEntrenamiento;
import com.certant.pokedexliteengrupo.pokemon.atributos.pokemonenentrenamiento.entity.PokemonEntrenadoAuxiliar;
import com.certant.pokedexliteengrupo.pokemon.atributos.pokemonenentrenamiento.service.IPokemonEnEntrenamientoService;
import com.certant.pokedexliteengrupo.pokemon.entity.Pokemon;
import com.certant.pokedexliteengrupo.pokemon.service.IPokemonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping({"/entrenador"})
public class EntrenadorController {

    @Autowired
    IEntrenadorService entrenadorService;
    
    @Autowired
    IPokemonService pokemonService;
    
    @Autowired
    IPokemonEnEntrenamientoService pokemonEnEntrenamientoService;

    @GetMapping({"/",""})
    public String findAll(Model model) {
        List<Entrenador> entrenadores = entrenadorService.findAll();
        model.addAttribute("title", "Lista de entrenadores");
        model.addAttribute("entrenadores", entrenadores);
        return "entrenador/findAll";
    }


    @GetMapping("/{id}")
    public String findById(@PathVariable(value = "id") Long id, Model model) {
        Entrenador entrenador = null;
        try {
            entrenador = entrenadorService.findById(id);
        } catch (EntrenadorNotFoundException e) {
            e.printStackTrace();
        }
        model.addAttribute("title", "Datos del Entrenador");
        model.addAttribute("entrenador", entrenador);
        return "entrenador/findById";
    }

    @RequestMapping("/form")
    public String formulario(Model model) {
        Entrenador entrenador = new Entrenador();
        model.addAttribute("title", "Alta de un entrenador");
        model.addAttribute("entrenador", entrenador);
        return "entrenador/form";
    }

    @PostMapping("/guardar")
    public String save(Entrenador entrenador) {
        // TODO: faltaría agregar validaciones a la vista, y save
        entrenadorService.save(entrenador);
        return "redirect:/entrenador/";
    }

    @GetMapping("/{id}/pokemones/")
    public String listarPokemonesPorEntrenador(@PathVariable(value = "id") Long id, Model model) {
        Entrenador entrenador = null;
        try {
            entrenador = entrenadorService.findById(id);
        } catch (EntrenadorNotFoundException e) {
            e.printStackTrace();
        }
        model.addAttribute("title", "Entrenador y sus pokemones");
        model.addAttribute("entrenador", entrenador);
        return "entrenador/pokemonsPorEntrenador";
    }
    
    @RequestMapping("/{id}/nuevoPokemon/")
    public String showNuevoPokemonForm(@PathVariable(value = "id") Long id, Model model) throws EntrenadorNotFoundException {
    	PokemonEntrenadoAuxiliar pokemonAuxiliar = new PokemonEntrenadoAuxiliar();
    	
    	model.addAttribute("pokemonEntrenado", pokemonAuxiliar);
    	model.addAttribute("title", "add nuevo pokemon");
    	model.addAttribute("pokemones", pokemonService.findAll());

    	return"pokemon/addPokemonEntrenado";
    }
    
    @PostMapping("/{id}/nuevoPokemon/guardarPokemon/")
    public String savePokemonEntrenado(@PathVariable(value = "id") Long id, PokemonEntrenadoAuxiliar pokemonEntrenado) throws Throwable {

    	Entrenador entrenador = entrenadorService.findById(id);
    	Pokemon pokemon = pokemonService.findById(pokemonEntrenado.getIdPokemon());
    	PokemonEnEntrenamiento nuevoPokemonEntrenado = new PokemonEnEntrenamiento();
    	
    	nuevoPokemonEntrenado.setEntrenador(entrenador);
    	nuevoPokemonEntrenado.setPokemon(pokemon);
    	nuevoPokemonEntrenado.setNivelActual(pokemonEntrenado.getNivelActual());
    	nuevoPokemonEntrenado.setId(null);//NECESARIO
    	pokemonEnEntrenamientoService.save(nuevoPokemonEntrenado);
    	
        return "redirect:/entrenador/{id}/pokemones/";
    }
    
}
