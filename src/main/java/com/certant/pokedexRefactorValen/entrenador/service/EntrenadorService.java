package com.certant.pokedexRefactorValen.entrenador.service;

import com.certant.pokedexRefactorValen.entrenador.entity.Entrenador;
import com.certant.pokedexRefactorValen.entrenador.repository.IEntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorService implements IEntrenadorService{

    @Autowired
    IEntrenadorRepository entrenadorRepository;

    @Override
    public List<Entrenador> findAll() {
        return (List<Entrenador>) entrenadorRepository.findAll();
    }
}
