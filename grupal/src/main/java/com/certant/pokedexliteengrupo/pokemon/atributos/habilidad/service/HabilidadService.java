/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.certant.pokedexliteengrupo.pokemon.atributos.habilidad.service;

import com.certant.pokedexliteengrupo.pokemon.atributos.habilidad.entity.Habilidad;
import com.certant.pokedexliteengrupo.pokemon.atributos.habilidad.exception.HabilidadInvalidIdException;
import com.certant.pokedexliteengrupo.pokemon.atributos.habilidad.exception.HabilidadInvalidNameException;
import com.certant.pokedexliteengrupo.pokemon.atributos.habilidad.exception.HabilidadNotFoundException;
import com.certant.pokedexliteengrupo.pokemon.atributos.habilidad.repository.IHabilidadRepository;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
