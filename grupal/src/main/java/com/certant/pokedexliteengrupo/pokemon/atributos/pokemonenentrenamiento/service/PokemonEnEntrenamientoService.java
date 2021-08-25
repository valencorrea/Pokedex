package com.certant.pokedexliteengrupo.pokemon.atributos.pokemonenentrenamiento.service;

import com.certant.pokedexliteengrupo.pokemon.atributos.pokemonenentrenamiento.entity.PokemonEnEntrenamiento;
import com.certant.pokedexliteengrupo.pokemon.atributos.pokemonenentrenamiento.repository.IPokemonEnEntrenamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonEnEntrenamientoService implements IPokemonEnEntrenamientoService{

    @Autowired
    IPokemonEnEntrenamientoRepository pokemonEnEntrenamientoRepository;

	@Override
	public PokemonEnEntrenamiento save (PokemonEnEntrenamiento pokemonEnEntrenamiento) {
		
		return pokemonEnEntrenamientoRepository.save(pokemonEnEntrenamiento);
	}



}
