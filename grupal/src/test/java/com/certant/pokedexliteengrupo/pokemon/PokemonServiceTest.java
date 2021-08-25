package com.certant.pokedexliteengrupo.pokemon;

import com.certant.pokedexliteengrupo.pokemon.entity.Pokemon;
import com.certant.pokedexliteengrupo.pokemon.exception.PokemonInvalidIdException;
import com.certant.pokedexliteengrupo.pokemon.exception.PokemonInvalidNameException;
import com.certant.pokedexliteengrupo.pokemon.exception.PokemonInvalidPointerException;
import com.certant.pokedexliteengrupo.pokemon.exception.PokemonNotFoundException;
import com.certant.pokedexliteengrupo.pokemon.service.IPokemonService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ComponentScan
class PokemonServiceTest {

    String[] nombresPokemones = {"Pikachu","Charmander","Bolbasour","Ratata"};
    Long[] nivelesPokemones = {(long)45, (long)50, (long)40, (long)30};

    @BeforeAll
    static void beforeAll() {
    }

    @Autowired
    IPokemonService pokemonService;
/*    @Test
    @DisplayName("Listar todos los Pokemones")
    void findAll() {
        List<Pokemon> pokemones = pokemonService.findAll();
        int i = 0;
        while (i<pokemones.size()){
            assertEquals(pokemones.get(i).getNombre(),nombresPokemones[i]);
            assertEquals(pokemones.get(i).getId(),(long) i);
            // assertEquals(pokemones.get(i).getNivel(), nivelesPokemones[i]);
            i++;
        }
    }
*/
    @Test
    @DisplayName("Validar atributos")
    void findById() throws Throwable {
        int i = 0;
        Pokemon pokemon = new Pokemon();

        while (i<nombresPokemones.length){
            try {
                pokemon = pokemonService.findById((long)i);
            } catch (PokemonInvalidNameException e) {
                e.printStackTrace();
            }
            assertEquals(pokemon.getId(),i);
            assertEquals(pokemon.getNombre(),nombresPokemones[i]);
            // assertEquals(pokemon.getNivel(), nivelesPokemones[i]);
            i++;
        }
    }

    @Test
    @DisplayName("Buscar pokemon con id invalido")
    void findInvalidId(){
        Pokemon pokemon = new Pokemon();
        assertThrows(PokemonInvalidIdException.class, () ->  pokemonService.findById((long) -1));

    }

    @Test
    @DisplayName("No puedo eliminar un ID inexistente")
    void eliminarIdInexistente(){
        Pokemon pokemon = new Pokemon();
        assertThrows(PokemonNotFoundException.class, () -> pokemonService.deleteById((long)90));
    }

    @Test
    @DisplayName("Un ID no registrado no se encuenrta en BBDD")
    void noExisteIdNoRegistrado() throws Throwable {

        assertFalse(pokemonService.existsById((long)15));
    }

    @Test
    @DisplayName("No existen pokemones con ID null")
    void noExisteIdNull() {

        assertThrows(PokemonInvalidIdException.class, () ->  pokemonService.deleteById(null));
    }

    @Test
    @DisplayName("Luego de eliminar un ID desaparece de BBDD")
    void verificarNoExistenciaDeEliminado() throws Throwable {

        pokemonService.deleteById((long)14);

        assertFalse(pokemonService.existsById((long)14));
    }

    @Test
    @DisplayName("Si guardo un pokemon comienza a existir en BBDD")
    void verificarExistenciaPokemonGuardado() throws PokemonInvalidPointerException {
        Pokemon pokemon = new Pokemon();
        pokemon.setNombre("un pokemon");
        Pokemon pokemonGuardado = pokemonService.save(pokemon);

        assertEquals(pokemon.getNombre(), pokemonGuardado.getNombre());
    }

    @Test
    @DisplayName("Si guardo un pokemon se incrementa la candidad en BBDD")
    void verificacionSaveCantidad() throws PokemonInvalidPointerException {
        Pokemon pokemon = new Pokemon();
        pokemon.setNombre("un pokemon");

        List<Pokemon> pokemones = pokemonService.findAll();
        int cantidadInicial = pokemones.size();

        pokemonService.save(pokemon);
        pokemones = pokemonService.findAll();;

        assertEquals(pokemones.size(), cantidadInicial+1);
    }

    @Test
    @DisplayName("Si cambio un nombre de un pokemon se actualiza en BBDD")
    void testUpdate () throws Throwable{
        int id=3;
        String nuevoNombre = "un nombre";

        Pokemon pokemon = pokemonService.findById((long)id);

        pokemon.setNombre(nuevoNombre);
        pokemonService.update(pokemon);

        assertEquals(pokemonService.findById((long)id).getNombre(), nuevoNombre);
    }
}