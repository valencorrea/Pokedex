package com.certant.pokedexRefactorValen.entrenador.service;

import com.certant.pokedexRefactorValen.entrenador.entity.Entrenador;
import com.certant.pokedexRefactorValen.entrenador.exceptions.EntrenadorNotFoundException;

import java.util.List;

public interface IEntrenadorService {
    List<Entrenador> findAll();

    boolean existsById(Long id) throws Throwable;

    Entrenador findById(Long id) throws Throwable;

    void deleteById(long id) throws Throwable;
}
