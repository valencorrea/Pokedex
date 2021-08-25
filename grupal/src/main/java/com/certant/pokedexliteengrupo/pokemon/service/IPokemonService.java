package com.certant.pokedexliteengrupo.pokemon.service;

import com.certant.pokedexliteengrupo.pokemon.entity.Pokemon;
import com.certant.pokedexliteengrupo.pokemon.exception.PokemonInvalidPointerException;

import java.util.List;

public interface IPokemonService {
    List<Pokemon> findAll();

    Pokemon findById(Long id) throws Throwable;

    void deleteById(Long id) throws Throwable;

    boolean existsById(Long id) throws Throwable;

    Pokemon save(Pokemon pokemon) throws PokemonInvalidPointerException;

    Pokemon update(Pokemon pokemon);
}
