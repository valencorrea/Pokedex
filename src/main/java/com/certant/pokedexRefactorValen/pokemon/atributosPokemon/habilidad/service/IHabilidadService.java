package com.certant.pokedexRefactorValen.pokemon.atributosPokemon.habilidad.service;

import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.habilidad.entity.Habilidad;
import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.habilidad.exceptions.HabilidadInvalidIdException;

import java.util.List;

public interface IHabilidadService {

    List<Habilidad> findAll();

    Habilidad findById(Long id) throws Throwable;

    void deleteById(Long id) throws Throwable;

    boolean existsById(Long id) throws Throwable;

    Habilidad save(Habilidad habilidad);

}
