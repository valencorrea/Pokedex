package com.certant.pokedexRefactorValen.pokemon.service;

import com.certant.pokedexRefactorValen.pokemon.entity.Pokemon;
import java.util.List;

public interface IPokemonService {
    List<Pokemon> findAll();

    Pokemon findById(long i) throws Throwable;

}
