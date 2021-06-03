package com.certant.pokedexRefactorValen.pokemon.atributosPokemon.habilidad.service;
import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.habilidad.exceptions.HabilidadInvalidIdException;
import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.habilidad.exceptions.HabilidadInvalidPointerException;
import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.habilidad.exceptions.HabilidadNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import static org.junit.jupiter.api.Assertions.*;

//@AutoConfigureBefore(CacheAutoConfiguration.class)
@DataJpaTest
@ComponentScan
public class HabilidadServiceTests {

    @BeforeAll
    static void beforeAll() {
    }

    @Autowired
    IHabilidadService habilidadService;


    /* * * * * * * * * * Pruebo las funciones con IDs negativos  * * * * * * * * * */

    @Test
    @DisplayName("No puedo buscar habilidades con IDs negativos")
    void siQuieroBuscarUnaHabilidadConIdNegativoArrojaError(){
        assertThrows(HabilidadInvalidIdException.class, () ->  habilidadService.findById((long) -1));

    }

    @Test
    @DisplayName("No puedo eliminar habilidades con IDs negativos")
    void siQuieroEliminarUnaHabilidadConIdNegativoArrojaError(){
        assertThrows(HabilidadInvalidIdException.class, () ->  habilidadService.deleteById((long) -1));

    }

    @Test
    @DisplayName("No existen IDs negativos")
    void siQuieroVerificarExistenciaUnaHabilidadConIdNegativoArrojaError(){
        assertThrows(HabilidadInvalidIdException.class, () ->  habilidadService.existsById((long) -1));

    }


    /* * * * * * * * * * Pruebo las funciones con IDs inexistentes * * * * * * * * * */

    @Test
    @DisplayName("No puedo eliminar un ID inexistente")
    void siQuieroEliminarIdInexistenteArrojaError(){
        assertThrows(HabilidadNotFoundException.class, () -> habilidadService.deleteById((long)90));
    }

    @Test
    @DisplayName("No puedo buscar un ID inexistente")
    void siQuieroBuscarIdInexistenteArrojaError(){
        assertThrows(HabilidadNotFoundException.class, () -> habilidadService.findById((long)90));
    }

    @Test
    @DisplayName("Un ID no registrado no se encuenrta en la base de datos")
    void siBuscoUnIdNoRegistradoNoExiste() throws Throwable {
        assertFalse(habilidadService.existsById((long)15));
    }

    @Test
    @DisplayName("No existen habilidades con ID null")
    void noSePuedenEliminarIdsNull() {
        assertThrows(HabilidadInvalidIdException.class, () ->  habilidadService.deleteById(null));
    }


    /* * * * * * * * * * Pruebas con parametros null * * * * * * * * * */
/*
    @Test
    @DisplayName("No puedo guardar una habilidad null")
    void siGuardoUnaHabilidadNullArrojaError() throws Throwable {
        assertThrows(HabilidadInvalidPointerException.class, () ->  habilidadService.save(null));
    }
*/

    /* * * * * * * * * * Pruebas de funcionamiento esperado * * * * * * * * * */
/*
    @Test
    @DisplayName("Luego de eliminar un ID desaparece de la base de datos")
    void siEliminoUnaHabilidadDesapareceDeLaBaseDeDatos() throws Throwable {
        habilidadService.deleteById((long)14);
        assertFalse(habilidadService.existsById((long)14));
    }

    @Test
    @DisplayName("Un Id cargado existe en la base de datos")
    void siCargueUnIdExisteEnLaBaseDeDatos() throws Throwable {
        assertTrue(habilidadService.existsById((long)1));
    }

    @Test
    @DisplayName("Si guardo una habilidad sus parametros coinciden con los que ingrese")
    void siGuardoUnaHabilidadSeGuardaEnLaBase() throws Throwable {
        Habilidad habilidad = new Habilidad();
        habilidad.setNombre("una habilidad");
        Habilidad habilidadGuardada = habilidadService.save(habilidad);

        assertEquals(habilidad.getNombre(), habilidadGuardada.getNombre());
        assertEquals(habilidad.getId(), habilidadGuardada.getId());

    }

    @Test
    @DisplayName("Si guardo una habilidad se incrementa la candidad en la base de datos")
    void siGuardoUnaHabilidadSeIncrementaLaCantidadEnLaBase() throws Throwable {
        List<Habilidad> habilidades = habilidadService.findAll();
        int cantidadInicial = habilidades.size();

        Habilidad habilidad = new Habilidad();
        habilidad.setNombre("una habilidad");

        habilidadService.save(habilidad);
        habilidades = habilidadService.findAll();;

        assertEquals(habilidades.size(), cantidadInicial+1);
    }*/

}
