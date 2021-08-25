package com.certant.pokedexliteengrupo.pokemon.atributos.pokemonenentrenamiento.repository;

import com.certant.pokedexliteengrupo.pokemon.atributos.pokemonenentrenamiento.entity.PokemonEnEntrenamiento;
import org.springframework.data.repository.CrudRepository;

public interface IPokemonEnEntrenamientoRepository extends CrudRepository<PokemonEnEntrenamiento,Long> {
}
