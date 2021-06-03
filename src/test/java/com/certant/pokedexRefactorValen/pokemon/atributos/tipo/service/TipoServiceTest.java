package com.certant.pokedexRefactorValen.pokemon.atributos.tipo.service;
import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.habilidad.service.IHabilidadService;
import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.tipo.exception.TipoInvalidIdException;
import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.tipo.exception.TipoInvalidPointerException;
import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.tipo.exception.TipoNotFoundException;
import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.tipo.service.ITipoService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@AutoConfigureBefore(CacheAutoConfiguration.class)
@DataJpaTest
@ComponentScan
public class TipoServiceTest {

    @BeforeAll
    static void beforeAll() {
    }

    @Autowired
    ITipoService tipoService;


    /* * * * * * * * * * Pruebo las funciones con IDs negativos  * * * * * * * * * */
/*
    @Test
    @DisplayName("No puedo buscar tipos con IDs negativos")
    void siQuieroBuscarUnTipoConIdNegativoArrojaError(){
        assertThrows(TipoInvalidIdException.class, () ->  tipoService.findById((long) -1));

    }

    @Test
    @DisplayName("No puedo eliminar tipos con IDs negativos")
    void siQuieroEliminarUnTipoConIdNegativoArrojaError(){
        assertThrows(TipoInvalidIdException.class, () ->  tipoService.deleteById((long) -1));

    }

    @Test
    @DisplayName("No existen IDs negativos")
    void siQuieroVerificarExistenciaUnTipoConIdNegativoArrojaError(){
        assertThrows(TipoInvalidIdException.class, () ->  tipoService.existsById((long) -1));

    }
*/

    /* * * * * * * * * * Pruebo las funciones con IDs inexistentes * * * * * * * * * */
/*
    @Test
    @DisplayName("No puedo eliminar un ID inexistente")
    void siQuieroEliminarIdInexistenteArrojaError(){
        assertThrows(TipoNotFoundException.class, () -> tipoService.deleteById((long)90));
    }

    @Test
    @DisplayName("No puedo buscar un ID inexistente")
    void siQuieroBuscarIdInexistenteArrojaError(){
        assertThrows(TipoNotFoundException.class, () -> tipoService.findById((long)90));
    }

    @Test
    @DisplayName("Un ID no registrado no se encuentra en la base de datos")
    void siBuscoUnIdNoRegistradoNoExiste() throws Throwable {
        assertFalse(tipoService.existsById((long)15));
    }

    @Test
    @DisplayName("No existen tipos con ID null")
    void noSePuedenEliminarIdsNull() {
        assertThrows(TipoInvalidIdException.class, () ->  tipoService.deleteById(null));
    }
*/

    /* * * * * * * * * * Pruebas con parametros null * * * * * * * * * */

/*    @Test
    @DisplayName("No puedo guardar un tipo null")
    void siGuardoUnTipoNullArrojaError() throws Throwable {
        assertThrows(TipoInvalidPointerException.class, () ->  tipoService.save(null));
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
    }
*/
}
