package com.certant.pokedexRefactorValen.pokemon.service;

import com.certant.pokedexRefactorValen.pokemon.entity.Pokemon;
import com.certant.pokedexRefactorValen.pokemon.exceptions.PokemonInvalidPointerException;

import java.util.List;

public interface IPokemonService {
    List<Pokemon> findAll();

    Pokemon findById(Long id) throws Throwable;

    void deleteById(Long id) throws Throwable;

    boolean existsById(Long id) throws Throwable;

    Pokemon save(Pokemon pokemon) throws Throwable;

    Pokemon update(Pokemon pokemon) throws Throwable;
}
