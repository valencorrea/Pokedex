package com.certant.pokedexliteengrupo.pokemon.atributos.evolucionaa.service;

import com.certant.pokedexliteengrupo.pokemon.atributos.evolucionaa.entity.EvolucionaA;
import com.certant.pokedexliteengrupo.pokemon.atributos.evolucionaa.repository.IEvolucionaARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvolucionaAService implements IEvolucionaAService{

    @Autowired
    IEvolucionaARepository evolucionaARepository;

    @Override
    public EvolucionaA save(EvolucionaA evolucionaA) {
        return evolucionaARepository.save(evolucionaA);
    }
}
