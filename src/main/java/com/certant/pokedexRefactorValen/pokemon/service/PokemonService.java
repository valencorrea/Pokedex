package com.certant.pokedexRefactorValen.pokemon.service;

import com.certant.pokedexRefactorValen.pokemon.entity.Pokemon;
import com.certant.pokedexRefactorValen.pokemon.repository.IPokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PokemonService implements IPokemonService {

    @Autowired
    IPokemonRepository pokemonRepository;

    @Override
    public List<Pokemon> findAll() {
        // retorno los pokemones de la base de datos
        return (List<Pokemon>) pokemonRepository.findAll();
    }

    @Override
    public Pokemon findById(long idPokemon) throws Throwable {

        Optional<Pokemon> pokemon = pokemonRepository.findById(idPokemon);
        return pokemon.get();
    }

}
