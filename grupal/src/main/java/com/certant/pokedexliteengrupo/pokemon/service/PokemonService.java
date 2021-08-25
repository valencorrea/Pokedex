package com.certant.pokedexliteengrupo.pokemon.service;

import com.certant.pokedexliteengrupo.pokemon.entity.Pokemon;
import com.certant.pokedexliteengrupo.pokemon.exception.PokemonInvalidIdException;
import com.certant.pokedexliteengrupo.pokemon.exception.PokemonInvalidNameException;
import com.certant.pokedexliteengrupo.pokemon.exception.PokemonInvalidPointerException;
import com.certant.pokedexliteengrupo.pokemon.exception.PokemonNotFoundException;
import com.certant.pokedexliteengrupo.pokemon.repository.IPokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PokemonService implements IPokemonService {

    @Autowired
    IPokemonRepository pokemonRepository;

    @Override
    public List<Pokemon> findAll() {
        return (List<Pokemon>) pokemonRepository.findAll();
    }

    @Override
    public Pokemon findById(Long id) throws Throwable {
        if(!existsById(id)){
            throw new PokemonNotFoundException("Id not found");
        }
        Optional<Pokemon> pokemon = pokemonRepository.findById(id);
        if (pokemon.isEmpty())
            throw new PokemonNotFoundException("Pokemon not found");
        return pokemon.get();
    }

    @Override
    public void deleteById(Long id) throws Throwable {
        if(!existsById(id)){
            throw new PokemonNotFoundException("Id not found");
        }
        pokemonRepository.deleteById(id);
    }

    public boolean existsById(Long id) throws Throwable {
        if((id==null) || (id<0)){
            throw new PokemonInvalidIdException("Invalid ID");
        }
        return pokemonRepository.existsById(id);
    }

    @Override
    public Pokemon save(Pokemon pokemon) throws PokemonInvalidPointerException {
        if(pokemon==null){
            throw new PokemonInvalidPointerException("Invalid pokemon pointer");
        }
        return pokemonRepository.save(pokemon);
    }

    @Override
    public Pokemon update(Pokemon pokemon) {
        if(pokemon.getNombre()==null || pokemon.getNombre().isEmpty()){
            try {
                throw new PokemonInvalidNameException("Nombre no valido");
            } catch (PokemonInvalidNameException ex) {
                Logger.getLogger(PokemonService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return pokemonRepository.save(pokemon);
    }

}
