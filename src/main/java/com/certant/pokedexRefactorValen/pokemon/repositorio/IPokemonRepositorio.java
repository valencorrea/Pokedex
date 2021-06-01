package com.certant.pokedexRefactorValen.pokemon.repositorio;

import com.certant.pokedexRefactorValen.pokemon.entidad.Pokemon;
import org.springframework.data.repository.CrudRepository;

// <clases con las que trabaja, tipo por el que se guia (id del pokemon)>
public interface IPokemonRepositorio extends CrudRepository<Pokemon,Long> {
}
