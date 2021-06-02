package com.certant.pokedexRefactorValen.pokemon.atributos.evolucion.service;

import com.certant.pokedexRefactorValen.pokemon.atributos.evolucion.entity.Evolucion;
import com.certant.pokedexRefactorValen.pokemon.atributos.evolucion.exceptions.EvolucionNullPointerException;
import com.certant.pokedexRefactorValen.pokemon.atributos.habilidad.entity.Habilidad;

import java.util.List;

public interface IEvolucionService {

    List<Evolucion> findAll();

    Evolucion findById(Long id) throws Throwable;

    void deleteById(Long id) throws Throwable;

    boolean existsById(Long id) throws Throwable;

    Evolucion save(Evolucion evolucion);

    Evolucion update(Evolucion evolucion) throws EvolucionNullPointerException, Throwable;
}
