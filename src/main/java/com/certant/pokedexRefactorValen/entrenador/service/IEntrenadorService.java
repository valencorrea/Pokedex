package com.certant.pokedexRefactorValen.entrenador.service;

import com.certant.pokedexRefactorValen.entrenador.entity.Entrenador;

import java.util.List;

public interface IEntrenadorService {
    List<Entrenador> findAll();
}
