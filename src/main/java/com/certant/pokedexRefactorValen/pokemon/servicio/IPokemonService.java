package com.certant.pokedexRefactorValen.pokemon.servicio;

import com.certant.pokedexRefactorValen.pokemon.entidad.Pokemon;
import java.util.List;

public interface IPokemonService {
    List<Pokemon> findAll();

    Pokemon findById(long i) throws Throwable;

}
