package com.certant.pokedexRefactorValen.pokemon.service;

import com.certant.pokedexRefactorValen.pokemon.entity.Pokemon;
import com.certant.pokedexRefactorValen.pokemon.exceptions.PokemonInvalidIdException;
import com.certant.pokedexRefactorValen.pokemon.exceptions.PokemonNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ComponentScan
public class PokemonServiceTest {

    String[] nombresPokemones = {"Pikachu","Charmander","Bolbasour","Ratata"};
    Long[] nivelesPokemones = {(long)45, (long)50, (long)40, (long)30};

    @BeforeAll
    static void beforeAll() {
    }

    @Autowired
    IPokemonService pokemonService;

    /* * * * * * * * * * Pruebo las funciones con IDs negativos  * * * * * * * * * */

    @Test
    @DisplayName("No puedo buscar pokemones con IDs negativos")
    void siQuieroBuscarUnPokemonConIdNegativoArrojaError(){
        assertThrows(PokemonInvalidIdException.class, () ->  pokemonService.findById((long) -1));

    }

    @Test
    @DisplayName("No puedo eliminar pokemones con IDs negativos")
    void siQuieroEliminarUnPokemonConIdNegativoArrojaError(){
        assertThrows(PokemonInvalidIdException.class, () ->  pokemonService.deleteById((long) -1));

    }


    /* * * * * * * * * * Pruebo las funciones con IDs inexistentes * * * * * * * * * */

    @Test
    @DisplayName("No puedo eliminar un ID inexistente")
    void siQuieroEliminarIdInexistenteArrojaError(){
        assertThrows(PokemonNotFoundException.class, () -> pokemonService.deleteById((long)90));
    }

    @Test
    @DisplayName("No puedo buscar un ID inexistente")
    void siQuieroBuscarIdInexistenteArrojaError(){
        assertThrows(PokemonNotFoundException.class, () -> pokemonService.findById((long)90));
    }

}