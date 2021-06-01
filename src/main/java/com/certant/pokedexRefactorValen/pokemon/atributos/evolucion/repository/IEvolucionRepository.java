package com.certant.pokedexRefactorValen.pokemon.atributos.evolucion.repository;

import com.certant.pokedexRefactorValen.pokemon.atributos.evolucion.entity.Evolucion;
import org.springframework.data.repository.CrudRepository;

public interface IEvolucionRepository extends CrudRepository<Evolucion,Long> {
}
