package com.certant.pokedexRefactorValen.pokemon.service;

import com.certant.pokedexRefactorValen.pokemon.entity.Pokemon;
import com.certant.pokedexRefactorValen.pokemon.exceptions.PokemonInvalidIdException;
import com.certant.pokedexRefactorValen.pokemon.exceptions.PokemonInvalidPointerException;
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

    @Test
    @DisplayName("No existen IDs negativos")
    void siQuieroVerificarExistenciaUnPokemonConIdNegativoArrojaError(){
        assertThrows(PokemonInvalidIdException.class, () ->  pokemonService.existsById((long) -1));

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

    @Test
    @DisplayName("Un ID no registrado no se encuenrta en la base de datos")
    void siBuscoUnIdNoRegistradoNoExiste() throws Throwable {
        assertFalse(pokemonService.existsById((long)15));
    }

    @Test
    @DisplayName("No existen pokemones con ID null")
    void noSePuedenEliminarIdsNull() {
        assertThrows(PokemonInvalidIdException.class, () ->  pokemonService.deleteById(null));
    }


    /* * * * * * * * * * Pruebas con parametros null * * * * * * * * * */

    @Test
    @DisplayName("No puedo guardar un pokemon null")
    void siGuardoUnPokemonNullArrojaError() throws Throwable {
        assertThrows(PokemonInvalidPointerException.class, () ->  pokemonService.save(null));
    }


    /* * * * * * * * * * Pruebas de funcionamiento esperado * * * * * * * * * */

    @Test
    @DisplayName("Luego de eliminar un ID desaparece de la base de datos")
    void siEliminoUnPokemonDesapareceDeLaBaseDeDatos() throws Throwable {
        pokemonService.deleteById((long)14);
        assertFalse(pokemonService.existsById((long)14));
    }

    @Test
    @DisplayName("Un Id cargado existe en la base de datos")
    void siCargueUnIdExisteEnLaBaseDeDatos() throws Throwable {
        assertTrue(pokemonService.existsById((long)1));
    }

    @Test
    @DisplayName("Si guardo un pokemon sus parametros coinciden con los que ingrese")
    void siGuardoUnPokemonSeGuardaEnLaBase() throws Throwable {
        Pokemon pokemon = new Pokemon();
        pokemon.setNombre("un pokemon");
        Pokemon pokemonGuardado = pokemonService.save(pokemon);

        assertEquals(pokemon.getNombre(), pokemonGuardado.getNombre());
        assertEquals(pokemon.getId(), pokemonGuardado.getId());
        assertEquals(pokemon.getNivel(), pokemonGuardado.getNivel());

    }

    @Test
    @DisplayName("Si guardo un pokemon se incrementa la candidad en la base de datos")
    void siGuardoUnPokemonSeIncrementaLaCantidadEnLaBase() throws Throwable {
        List<Pokemon> pokemones = pokemonService.findAll();
        int cantidadInicial = pokemones.size();

        Pokemon pokemon = new Pokemon();
        pokemon.setNombre("un pokemon");

        pokemonService.save(pokemon);
        pokemones = pokemonService.findAll();;

        assertEquals(pokemones.size(), cantidadInicial+1);
    }

    @Test
    @DisplayName("Si cambio un nombre de un pokemon se actualiza en BBDD")
    void siCambioUnNombreSeActualizaEnLaBase () throws Throwable{
        int id=3;
        String nuevoNombre = "un nombre";

        Pokemon pokemon = pokemonService.findById((long)id);

        pokemon.setNombre(nuevoNombre);
        pokemonService.update(pokemon);

        assertEquals(pokemonService.findById((long)id).getNombre(), nuevoNombre);
    }

}
