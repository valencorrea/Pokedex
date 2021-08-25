package com.certant.pokedexRefactorValen.entrenador.service;

import com.certant.pokedexRefactorValen.entrenador.entity.Entrenador;
import com.certant.pokedexRefactorValen.entrenador.exceptions.EntrenadorInvalidIdException;
import com.certant.pokedexRefactorValen.entrenador.exceptions.EntrenadorInvalidPointerException;
import com.certant.pokedexRefactorValen.entrenador.exceptions.EntrenadorNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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


    /* * * * * * * * * * Pruebo las funciones con IDs inexistentes * * * * * * * * * */

    @Test
    @DisplayName("No puedo eliminar un ID inexistente")
    void siQuieroEliminarIdInexistenteArrojaError(){
        assertThrows(EntrenadorNotFoundException.class, () -> entrenadorService.deleteById((long)90));
    }

    @Test
    @DisplayName("No puedo buscar un ID inexistente")
    void siQuieroBuscarIdInexistenteArrojaError(){
        assertThrows(EntrenadorNotFoundException.class, () -> entrenadorService.findById((long)90));
    }

    @Test
    @DisplayName("Un ID no registrado no se encuenrta en la base de datos")
    void siBuscoUnIdNoRegistradoNoExiste() throws Throwable {
        assertFalse(entrenadorService.existsById((long)15));
    }

    @Test
    @DisplayName("No existen entrenadores con ID null")
    void noSePuedenEliminarIdsNull() {
        assertThrows(EntrenadorInvalidIdException.class, () -> entrenadorService.deleteById(null));
    }


    /* * * * * * * * * * Pruebas con parametros null * * * * * * * * * */

    @Test
    @DisplayName("No puedo guardar un entrenador null")
    void siGuardoUnEntrenadorNullArrojaError() throws Throwable {
        assertThrows(EntrenadorInvalidPointerException.class, () ->  entrenadorService.save(null));
    }


    /* * * * * * * * * * Pruebas de funcionamiento esperado * * * * * * * * * */

    @Test
    @DisplayName("Un ID cargado existe en la base de datos")
    void unIdCargadoExisteEnBase() throws Throwable {
        assertTrue(entrenadorService.existsById((long)1));
    }

    @Test
    @DisplayName("Luego de eliminar un ID desaparece de la base de datos")
    void siEliminoUnEntrenadorDesapareceDeLaBaseDeDatos() throws Throwable {
        entrenadorService.deleteById((long)1);
        assertFalse(entrenadorService.existsById((long)1));
    }

    @Test
    @DisplayName("Un Id cargado existe en la base de datos")
    void siCargueUnIdExisteEnLaBaseDeDatos() throws Throwable {
        assertTrue(entrenadorService.existsById((long)1));
    }

    @Test
    @DisplayName("Si guardo un entrenador sus parametros coinciden con los que ingrese")
    void siGuardoUnEntrenadorSeGuardaEnLaBase() throws Throwable {
        Entrenador entrenador = new Entrenador();
        entrenador.setNombre("un entrenador");
        Entrenador entrenadorGuardado = entrenadorService.save(entrenador);

        assertEquals(entrenador.getNombre(), entrenadorGuardado.getNombre());
        assertEquals(entrenador.getId(), entrenadorGuardado.getId());

    }

    @Test
    @DisplayName("Si guardo un entrenador se incrementa la candidad en la base de datos")
    void siGuardoUnEntrenadorSeIncrementaLaCantidadEnLaBase() throws Throwable {
        List<Entrenador> entrenadores = entrenadorService.findAll();
        int cantidadInicial = entrenadores.size();

        Entrenador entrenador = new Entrenador();
        entrenador.setNombre("un entrenador");

        entrenadorService.save(entrenador);
        entrenadores = entrenadorService.findAll();;

        assertEquals(entrenadores.size(), cantidadInicial+1);
    }

}