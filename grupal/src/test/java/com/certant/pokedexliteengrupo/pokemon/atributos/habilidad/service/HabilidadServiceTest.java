package com.certant.pokedexliteengrupo.pokemon.atributos.habilidad.service;

import com.certant.pokedexliteengrupo.pokemon.atributos.habilidad.entity.Habilidad;
import com.certant.pokedexliteengrupo.pokemon.atributos.habilidad.exception.HabilidadInvalidIdException;
import com.certant.pokedexliteengrupo.pokemon.atributos.habilidad.exception.HabilidadNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ComponentScan
class HabilidadServiceTest {
    @Autowired
    IHabilidadService habilidadService;

    String[] nombreshabilidades = {"Impactrueno","Volar","Correr","Envenenar","Relampago de Voltajes","Flexibilidad","Mar Llamas","Torrente","Vista Lince","Agallas","Espesura"};

    @Test
    @DisplayName("Listar todas las Habilidades")
    void findAll() {
        List<Habilidad> habilidades = habilidadService.findAll();
        int i = 0;
        while (i<habilidades.size()){
            assertEquals(habilidades.get(i).getNombre(), nombreshabilidades[i]);
            assertEquals(habilidades.get(i).getId(), (long) i);
            i++;
        }
    }

    @Test
    @DisplayName("Buscar Habilidad por id")
    void findById() {
        int i = 0;
        Habilidad habilidad = new Habilidad();
        while (i<nombreshabilidades.length){
            try {
                habilidad = habilidadService.findById((long)i);
            } catch (Throwable e) {
                e.printStackTrace();
            }
            assertEquals(habilidad.getId(),i);
            assertEquals(habilidad.getNombre(),nombreshabilidades[i]);
            i++;
        }
    }

    @Test
    @DisplayName("Buscar habilidad con id invalido")
    void findInvalidId(){
        Habilidad habilidad = new Habilidad();
        assertThrows(HabilidadInvalidIdException.class, () ->  habilidadService.findById((long) -1));
    }

    @Test
    @DisplayName("No puedo eliminar un ID inexistente")
    void eliminarIdInexistente(){
        Habilidad habilidad = new Habilidad();
        assertThrows(HabilidadNotFoundException.class, () ->  habilidadService.deleteById((long) 200));
    }

    @Test
    @DisplayName("Un ID no registrado no se encuenrta en BBDD")
    void noExisteIdNoRegistrado() throws HabilidadInvalidIdException {

        assertFalse(habilidadService.existsById((long)15));
    }

    @Test
    @DisplayName("No existen habilidades con ID null")
    void noExisteIdNull() throws HabilidadInvalidIdException {

        assertThrows(HabilidadInvalidIdException.class, () ->  habilidadService.deleteById(null));
    }

    @Test
    @DisplayName("Luego de eliminar un ID desaparece de BBDD")
    void verificarNoExistenciaDeEliminado() throws Throwable {

        habilidadService.deleteById((long)1);

        assertFalse(habilidadService.existsById((long)1));
    }

    @Test
    @DisplayName("Si guardo una habilidad comienza a existir en BBDD")
    void verificarExistenciaHablidadGuardada() {
        Habilidad habilidad = new Habilidad();
        habilidad.setNombre("una habilidad");
        Habilidad habilidadGuardada = habilidadService.save(habilidad);

        assertEquals(habilidad.getNombre(), habilidadGuardada.getNombre());
    }

    @Test
    @DisplayName("Si guardo una habilidad se incrementa la candidad en BBDD")
    void verificacionSaveCantidad(){
        Habilidad habilidad = new Habilidad();
        habilidad.setNombre("una habilidad");

        List<Habilidad> habilidades = habilidadService.findAll();
        int cantidadInicial = habilidades.size();

        habilidadService.save(habilidad);

        habilidades = habilidadService.findAll();;

        assertEquals(habilidades.size(), cantidadInicial+1);
    }
    
    @Test
    @DisplayName("verificacion update")
    void testUpdate () throws Throwable{
        int id=3;
        String nombreEsperado = "Nadar";
        Habilidad habilidad = habilidadService.findById((long)id);

        habilidad.setNombre(nombreEsperado);
        habilidadService.update(habilidad);

        assertEquals(habilidadService.findById((long)id).getNombre(), nombreEsperado);
    }
}