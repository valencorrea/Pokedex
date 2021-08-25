package com.certant.pokedexRefactorValen.pokemon.service;

import com.certant.pokedexRefactorValen.pokemon.entity.Pokemon;
import com.certant.pokedexRefactorValen.pokemon.exceptions.PokemonInvalidIdException;
import com.certant.pokedexRefactorValen.pokemon.exceptions.PokemonInvalidNameException;
import com.certant.pokedexRefactorValen.pokemon.exceptions.PokemonInvalidPointerException;
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

    private void validarId(Long id) throws Throwable {
        if(id == null)
            throw new PokemonInvalidIdException("No se puede trabajar con IDs null");

        if(id < 0)
            throw new PokemonInvalidIdException("No se puede trabajar con IDs negativos");

    }

    private void validarPokemon(Pokemon pokemon) throws Throwable {
        if (pokemon == null)
            throw new PokemonInvalidPointerException("No se puede trabajar con una direccion de memoria invalida");

        if(pokemon.getNombre() == null)
            throw new PokemonInvalidNameException("No se puede trabajar con un nombre invalido");

        if (pokemon.getNombre().isEmpty())
            throw new PokemonInvalidNameException("No se puede trabajar con un nombre invalido");
    }

    @Override
    public List<Pokemon> findAll() {
        return (List<Pokemon>) pokemonRepository.findAll();
    }

    @Override
    public Pokemon findById(Long id) throws Throwable {
        validarId(id);
        if(!existsById(id))
            throw new PokemonNotFoundException("No existe el ID del pokemon solicitado en la base de datos");

        Optional<Pokemon> pokemon = pokemonRepository.findById(id);
        return pokemon.get();
    }

    @Override
    public void deleteById(Long id) throws Throwable {
        if(!existsById(id))
            throw new PokemonNotFoundException("No existe el ID del pokemon solicitado en la base de datos");

        pokemonRepository.deleteById(id);
    }

    public boolean existsById(Long id) throws Throwable {
        validarId(id);
        return pokemonRepository.existsById(id);
    }

    @Override
    public Pokemon save(Pokemon pokemon) throws Throwable {
        validarPokemon(pokemon);
        return pokemonRepository.save(pokemon);
    }

    @Override
    public Pokemon update(Pokemon pokemon) throws Throwable {
        return pokemonRepository.save(pokemon);
    }

}
