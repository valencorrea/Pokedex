/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.certant.pokedexRefactorValen.pokemon.atributosPokemon.habilidad.service;

import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.habilidad.entity.Habilidad;
import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.habilidad.exceptions.HabilidadInvalidIdException;
import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.habilidad.exceptions.HabilidadInvalidNameException;
import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.habilidad.exceptions.HabilidadInvalidPointerException;
import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.habilidad.exceptions.HabilidadNotFoundException;
import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.habilidad.repository.IHabilidadRepository;
import com.certant.pokedexRefactorValen.pokemon.entity.Pokemon;
import com.certant.pokedexRefactorValen.pokemon.exceptions.PokemonInvalidNameException;
import com.certant.pokedexRefactorValen.pokemon.exceptions.PokemonInvalidPointerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class HabilidadService implements IHabilidadService{
    @Autowired
    IHabilidadRepository habilidadRepository;

    @Override
    public List<Habilidad> findAll() {
        return (List<Habilidad>) habilidadRepository.findAll();
    }

    @Override
    public Habilidad findById(Long id) throws Throwable {
        if(!existsById(id)){
            throw new HabilidadNotFoundException("Id not found");
        }
        Optional<Habilidad> habilidad = habilidadRepository.findById(id);
        if (habilidad.isEmpty())
            throw new HabilidadNotFoundException("Ability not found");
        return habilidad.get();
    }

    @Override
    public void deleteById(Long id) throws Throwable {
        if(!existsById(id)){
            throw new HabilidadNotFoundException("Id not found");
        }
        habilidadRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) throws Throwable {
        if((id==null) || (id<0)){
            throw new HabilidadInvalidIdException("Invalid ID");
        }
        return habilidadRepository.existsById(id);
    }

    @Override
    public Habilidad save(Habilidad habilidad) throws Throwable {
        validarHabilidad(habilidad);
        return habilidadRepository.save(habilidad);
    }

    private void validarHabilidad(Habilidad habilidad) throws Throwable {
        if (habilidad == null)
            throw new HabilidadInvalidPointerException("No se puede trabajar con una direccion de memoria invalida");

        if(habilidad.getNombre() == null)
            throw new HabilidadInvalidNameException("No se puede trabajar con un nombre invalido");

        if (habilidad.getNombre().isEmpty())
            throw new HabilidadInvalidNameException("No se puede trabajar con un nombre invalido");
    }
}
