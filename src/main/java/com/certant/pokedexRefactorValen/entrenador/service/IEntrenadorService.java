package com.certant.pokedexRefactorValen.entrenador.service;

import com.certant.pokedexRefactorValen.entrenador.entity.Entrenador;

import java.util.List;

public interface IEntrenadorService {
    List<Entrenador> findAll();

    boolean existsById(Long id) throws Throwable;

    Entrenador findById(Long id) throws Throwable;

    void deleteById(Long id) throws Throwable;

    Entrenador save(Entrenador entrenador) throws Throwable;

}
