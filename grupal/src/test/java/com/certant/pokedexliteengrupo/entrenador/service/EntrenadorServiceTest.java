package com.certant.pokedexliteengrupo.entrenador.service;
import com.certant.pokedexliteengrupo.entrenador.entity.Entrenador;
import com.certant.pokedexliteengrupo.entrenador.exception.EntrenadorNotFoundException;
import com.certant.pokedexliteengrupo.pokemon.atributos.pokemonenentrenamiento.entity.PokemonEnEntrenamiento;
import com.certant.pokedexliteengrupo.pokemon.atributos.pokemonenentrenamiento.exceptions.PokemonEntrenamientoNotFound;
import com.certant.pokedexliteengrupo.pokemon.exception.PokemonInvalidIdException;
import org.junit.jupiter.api.AfterAll;
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
class EntrenadorServiceTest {
    /*
     List<Entrenador> entrenadoresTest = Arrays.asList(new Entrenador(0L,"Ash"),new Entrenador(1L,"Misty"),
        new Entrenador(2L,"Brock"),new Entrenador(3L,"Rojo"),new Entrenador(4L,"Azul"),new Entrenador(3L,"Oak"));
     */
    String[] nombresEntrenadores = {"Ash","Misty","Brock","Rojo","Azul","Oak"};
    String[] nombresPokemonsEntrenamiento = {"Pikachu","Ratata","Charmander","Bolbasour"};
    Integer[] pokemonesId = {0,3,1,2};

    @BeforeAll
    static void beforeAll() {
    }

    @Autowired
    IEntrenadorService entrenadorService;
    @Test
    @DisplayName("Listar todos los Entrenadores")
    void findAll() {
        List<Entrenador> entrenadores = entrenadorService.findAll();
        int i = 0;
        while (i<entrenadores.size()){
            assertEquals(entrenadores.get(i).getNombre(),nombresEntrenadores[i]);
            assertEquals(entrenadores.get(i).getId(),(long) i);
            i++;
        }
    }

    @Test
    @DisplayName("Listo los pokemones de un entrenador en especifico")
    void showAllPokemons() throws Throwable {
        Entrenador entrenador = entrenadorService.findById((long)0);
        int i=0;
        List<PokemonEnEntrenamiento> pokemonsEntrenamiento = entrenador.getPokemonsEntrenamiento();

        while(i<pokemonsEntrenamiento.size()){
            assertEquals(pokemonsEntrenamiento.get(i).getPokemon().getNombre(), nombresPokemonsEntrenamiento[i]);
            assertTrue(pokemonsEntrenamiento.get(i).getPokemon().getId()==(long) pokemonesId[i]);
            i++;
        }
    }

    @Test
    @DisplayName("Buscar Entrenador por id")
    void findById() {
        int i = 0;
        Entrenador entrenador=new Entrenador();
        while (i<nombresEntrenadores.length){
            try {
                entrenador = entrenadorService.findById((long)i);
            } catch (EntrenadorNotFoundException e) {
                e.printStackTrace();
            }
            assertEquals(entrenador.getId(),i);
            assertEquals(entrenador.getNombre(),nombresEntrenadores[i]);
            i++;
        }
    }
}