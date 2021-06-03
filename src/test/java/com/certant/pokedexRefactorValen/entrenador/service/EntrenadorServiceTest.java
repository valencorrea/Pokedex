package com.certant.pokedexRefactorValen.entrenador.service;

import com.certant.pokedexRefactorValen.entrenador.entity.Entrenador;
import com.certant.pokedexRefactorValen.entrenador.exceptions.EntrenadorInvalidIdException;
import com.certant.pokedexRefactorValen.pokemon.exceptions.PokemonInvalidIdException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@ComponentScan
class EntrenadorServiceTest {

    @BeforeAll
    static void beforeAll() {
    }

    @Autowired
    IEntrenadorService entrenadorService;

    /* * * * * * * * * * Pruebo las funciones con IDs negativos  * * * * * * * * * */

    @Test
    @DisplayName("No puedo buscar pokemones con IDs negativos")
    void siQuieroBuscarEntrenadorConIdNegativoArrojaError(){
        assertThrows(EntrenadorInvalidIdException.class, () ->  entrenadorService.findById((long) -1));

    }

    @Test
    @DisplayName("No puedo eliminar pokemones con IDs negativos")
    void siQuieroEliminarUnEntrenadorConIdNegativoArrojaError(){
        assertThrows(EntrenadorInvalidIdException.class, () ->  entrenadorService.deleteById((long) -1));

    }

    @Test
    @DisplayName("No existen IDs negativos")
    void siQuieroVerificarExistenciaUnPokemonConIdNegativoArrojaError(){
        assertThrows(EntrenadorInvalidIdException.class, () ->  entrenadorService.existsById((long) -1));

    }



    /* * * * * * * * * * Pruebo las funciones con comportamiento esperado  * * * * * * * * * */

    @Test
    @DisplayName("Un ID cargado existe en la base de datos")
    void unIdCargadoExisteEnBase() throws Throwable {
        assertTrue(entrenadorService.existsById((long)1));
    }

}