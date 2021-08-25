package com.certant.pokedexliteengrupo.pokemon.atributos.habilidad.service;

import com.certant.pokedexliteengrupo.pokemon.atributos.habilidad.entity.Habilidad;
import com.certant.pokedexliteengrupo.pokemon.atributos.habilidad.exception.HabilidadInvalidIdException;
import com.certant.pokedexliteengrupo.pokemon.atributos.habilidad.exception.HabilidadNotFoundException;

import java.util.List;

public interface IHabilidadService {
    List<Habilidad> findAll();

    Habilidad findById(Long i) throws HabilidadNotFoundException, Throwable;

    void deleteById(Long id) throws HabilidadNotFoundException, Throwable;

    boolean existsById(Long id) throws HabilidadInvalidIdException;

    Habilidad save(Habilidad habilidad);
    
    Habilidad update(Habilidad habilidad);
}
