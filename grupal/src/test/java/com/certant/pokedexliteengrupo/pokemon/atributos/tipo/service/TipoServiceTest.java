package com.certant.pokedexliteengrupo.pokemon.atributos.tipo.service;

import com.certant.pokedexliteengrupo.pokemon.atributos.tipo.entity.Tipo;
import com.certant.pokedexliteengrupo.pokemon.atributos.tipo.exception.TipoNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ComponentScan
class TipoServiceTest {
    @Autowired
    ITipoService tipoService;

    String[] nombresTipos = {"Planta","Veneno","Fuego","Volador","Agua","Bicho","Normal","Electrico","Tierra","Hada"};

    @Test
    @DisplayName("Listar todos los Tipos")
    void findAll() {
        List<Tipo> tipos = tipoService.findAll();
        int i = 0;
        while (i<tipos.size()){
            assertEquals(tipos.get(i).getNombre(),nombresTipos[i]);
            assertEquals(tipos.get(i).getId(),(long) i);
            i++;
        }
    }

    @Test
    @DisplayName("Buscar Tipo por id")
    void findById() {
        int i = 0;
        Tipo tipo=new Tipo();
        while (i<nombresTipos.length){
            try {
                tipo = tipoService.findById((long)i);
            } catch (TipoNotFoundException e) {
                e.printStackTrace();
            }
            assertEquals(tipo.getId(),i);
            assertEquals(tipo.getNombre(),nombresTipos[i]);
            i++;
        }
    }
    
    @Test
    @DisplayName("Eliminar tipo por id")        
    void deleteById() throws TipoNotFoundException{
        
        int id=1;
        tipoService.deleteById((long)id);
        List<Tipo> tipos = tipoService.findAll();
        
        assertEquals(tipos.size(), 9);
    }
    
    @Test
    @DisplayName("verificar tipo existente por id")        
    void verificarIdValido() throws TipoNotFoundException{
        
        int id=1;
        assertTrue(tipoService.existsById((long)id));
    }
    
    @Test
    @DisplayName("verificar tipo inexistente por id")        
    void verificarIdInvalido() throws TipoNotFoundException{
        
        int id=15;
        assertFalse(tipoService.existsById((long)id));
    }
    
    @Test
    @DisplayName("verificar tipo id null")        
    void verificarIdNull() throws TipoNotFoundException{
        
        assertFalse(tipoService.existsById(null));
    }
    
    @Test
    @DisplayName("verificarNoExistenciaDeEliminado")        
    void verificarNoExistenciaDeEliminado() throws TipoNotFoundException{
        
        int id=1;
        tipoService.deleteById((long)id);
        
        assertFalse(tipoService.existsById((long)id));
    }
    
    @Test
    @DisplayName("verificacionSave")        
    void verificacionSave() throws TipoNotFoundException{
        Tipo tipo = new Tipo();
        tipo.setNombre("Bart");
        Tipo expected = tipoService.save(tipo);

        List<Tipo> tipos = tipoService.findAll();
       assertEquals(tipo.getNombre(), expected.getNombre());
    }
    
    @Test
    @DisplayName("verificacionSaveCantidad")        
    void verificacionSaveCantidad() throws TipoNotFoundException{
        Tipo tipo = new Tipo();
        tipo.setNombre("Homero");
        
        List<Tipo> tipos = tipoService.findAll();
        int cantidadEsperada = tipos.size();
        
        tipoService.save(tipo);
        
        tipos = tipoService.findAll();
        cantidadEsperada+=1;
        assertEquals(tipos.size(),cantidadEsperada);
    }
    
    @Test
    @DisplayName("verificacion update")
    void testUpdate () throws TipoNotFoundException{
        int id=3;
        String nombreEsperado = "Acomer";
        Tipo tipo = tipoService.findById((long)id);
        tipo.setNombre(nombreEsperado);
        tipoService.update(tipo);
        tipo = tipoService.findById((long)id);
        
        assertEquals(tipo.getNombre(), nombreEsperado);
    }
    
   /* @Test //revisar excepcion
    @DisplayName("update null")
    void testUpdateNull () throws TipoNotFoundException{
        int id=3;
        var tipo = tipoService.findById((long)id);
        tipo.setNombre(null);
        tipoService.update(tipo);
        
        assertThrows(TipoNotFoundException.class, () ->tipoService.update(tipo));
    }
    */
    
}