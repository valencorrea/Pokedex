/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.certant.pokedexRefactorValen.pokemon.atributosPokemon.habilidad.service;

import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.habilidad.entity.Habilidad;
import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.habilidad.exceptions.HabilidadInvalidIdException;
import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.habilidad.exceptions.HabilidadInvalidNameException;
import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.habilidad.exceptions.HabilidadNotFoundException;
import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.habilidad.repository.IHabilidadRepository;
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
    public boolean existsById(Long id) throws HabilidadInvalidIdException {
        if((id==null) || (id<0)){
            throw new HabilidadInvalidIdException("Invalid ID");
        }
        return habilidadRepository.existsById(id);
    }

    @Override
    public Habilidad save(Habilidad habilidad) {
        return habilidadRepository.save(habilidad);
    }

    @Override
    public Habilidad update(Habilidad habilidad) {
        if(habilidad.getNombre()==null || habilidad.getNombre().isEmpty()){
            try {
                throw new HabilidadInvalidNameException("Nombre no valido");
            } catch (HabilidadInvalidNameException ex) {
                Logger.getLogger(HabilidadService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return habilidadRepository.save(habilidad);
    }
}
