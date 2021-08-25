package com.certant.pokedexRefactorValen.entrenador.repository;

import com.certant.pokedexRefactorValen.entrenador.entity.Entrenador;
import org.springframework.data.repository.CrudRepository;

public interface IEntrenadorRepository extends CrudRepository<Entrenador,Long> {
}
