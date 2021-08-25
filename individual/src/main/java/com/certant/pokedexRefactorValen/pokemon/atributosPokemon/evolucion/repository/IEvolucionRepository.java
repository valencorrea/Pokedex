package com.certant.pokedexRefactorValen.pokemon.atributosPokemon.evolucion.repository;

import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.evolucion.entity.Evolucion;
import org.springframework.data.repository.CrudRepository;

public interface IEvolucionRepository extends CrudRepository<Evolucion,Long> {
}
