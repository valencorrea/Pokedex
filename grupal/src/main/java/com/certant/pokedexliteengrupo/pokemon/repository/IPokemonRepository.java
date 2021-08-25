package com.certant.pokedexliteengrupo.pokemon.repository;

import com.certant.pokedexliteengrupo.pokemon.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IPokemonRepository extends JpaRepository<Pokemon,Long> {
}
