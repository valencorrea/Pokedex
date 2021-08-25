package com.certant.pokedexliteengrupo.entrenador.service;

import com.certant.pokedexliteengrupo.entrenador.entity.Entrenador;
import com.certant.pokedexliteengrupo.entrenador.exception.EntrenadorNotFoundException;
import com.certant.pokedexliteengrupo.entrenador.repository.IEntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorService implements IEntrenadorService{

    @Autowired
    IEntrenadorRepository entrenadorRepository;


    @Override
    public List<Entrenador> findAll(){
        return (List<Entrenador>) entrenadorRepository.findAll();
    }

    @Override
    public Entrenador findById(Long id) throws EntrenadorNotFoundException {
        Optional<Entrenador> entrenador = entrenadorRepository.findById(id);
        if (entrenador.isEmpty())
            throw new EntrenadorNotFoundException("Entrenador not found");
        return entrenador.get();
    }

    @Override
    public Entrenador save(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }
}
