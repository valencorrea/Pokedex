package com.certant.pokedexRefactorValen.pokemon.atributosPokemon.evolucion.service;

import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.evolucion.entity.Evolucion;
import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.evolucion.repository.IEvolucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvolucionService implements IEvolucionService{
    @Autowired
    IEvolucionRepository evolucionRepository;

    @Override
    public List<Evolucion> findAll() {
        return (List<Evolucion>) evolucionRepository.findAll();
    }

}
