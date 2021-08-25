package com.certant.pokedexRefactorValen.pokemon.repository;

import com.certant.pokedexRefactorValen.pokemon.entity.Pokemon;
import org.springframework.data.repository.CrudRepository;

// <clases con las que trabaja, tipo por el que se guia (id del pokemon)>
public interface IPokemonRepository extends CrudRepository<Pokemon,Long> {
}
