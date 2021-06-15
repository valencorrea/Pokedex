package com.certant.pokedexRefactorValen.pokemon.controller;

import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.evolucion.entity.Evolucion;
import com.certant.pokedexRefactorValen.pokemon.entity.Pokemon;
import com.certant.pokedexRefactorValen.pokemon.service.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @ResponseBody
    @GetMapping("/nombrePokemon/")
    //public String mostrarNombreEnNavegador(Long id) throws Throwable {
    public String mostrarNombreEnNavegador() throws Throwable {
        //Pokemon pokemon = pokemonService.findById(id);
        //System.out.print("\n" +  id + "\n");
        //return "El pokemon seleccionado es: " + pokemon.getNombre();

        return "funciona";
    }

/*    @GetMapping("/nombrePokemon")
    public String findById(@PathVariable(value = "id") Long id, Model model) throws Throwable {
        Pokemon pokemon = pokemonService.findById(id);
        return "El pokemon seleccionado es: " + pokemon.getNombre();
    }*/

    // Si está utilizando un Servlet de Java, necesita crear un HttpServlet personalizado,
    // que debe implementar las funciones doGet(HttpServletRequest req, HttpServletResponse resp) y
    // doPost(HttpRequest req, HttpResponse resp). Una vez que asigne un nombre de dominio específico (contextpath/FirstServlet en su ejemplo) a
    // su clase de servlet personalizada (en su archivo web.xml), el servlet enrutará automáticamente cualquier get o post Solicita a tus funciones doGet o doPost.
}
