package com.certant.pokedexRefactorValen.pokemon.service;

import com.certant.pokedexRefactorValen.pokemon.entity.Pokemon;
import com.certant.pokedexRefactorValen.pokemon.exceptions.PokemonInvalidIdException;
import com.certant.pokedexRefactorValen.pokemon.exceptions.PokemonNotFoundException;
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
    public Pokemon findById(Long id) throws Throwable {
        if(id < 0)
            throw new PokemonInvalidIdException("No se pueden buscar pokemones con IDs negativos");

        if(!existsById(id))
            throw new PokemonNotFoundException("No existe el ID del pokemon solicitado en la base de datos");

        Optional<Pokemon> pokemon = pokemonRepository.findById(id);
        return pokemon.get();
    }

    @Override
    public void deleteById(Long id) throws Throwable {
        if(id == null)
            throw new PokemonInvalidIdException("No se pueden eliminar pokemones con IDs null");

        if(id < 0)
            throw new PokemonInvalidIdException("No se pueden eliminar pokemones con IDs negativos");

        if(!existsById(id))
            throw new PokemonNotFoundException("No existe el ID del pokemon solicitado en la base de datos");

    }

    public boolean existsById(Long id) {
        return pokemonRepository.existsById(id);
    }

}
