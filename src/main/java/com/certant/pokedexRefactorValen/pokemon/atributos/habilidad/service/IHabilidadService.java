package com.certant.pokedexRefactorValen.pokemon.atributos.habilidad.service;

import com.certant.pokedexRefactorValen.pokemon.atributos.habilidad.entity.Habilidad;
import com.certant.pokedexRefactorValen.pokemon.atributos.habilidad.exceptions.HabilidadInvalidIdException;
import java.util.List;

public interface IHabilidadService {

    List<Habilidad> findAll();

    Habilidad findById(Long id) throws Throwable;

    void deleteById(Long id) throws Throwable;

    boolean existsById(Long id) throws HabilidadInvalidIdException;

    Habilidad save(Habilidad habilidad);

    Habilidad update(Habilidad habilidad);
}
