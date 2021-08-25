package com.certant.pokedexliteengrupo.entrenador.service;

import com.certant.pokedexliteengrupo.entrenador.entity.Entrenador;
import com.certant.pokedexliteengrupo.entrenador.exception.EntrenadorNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IEntrenadorService {
    List<Entrenador> findAll();
    Entrenador findById(Long id) throws EntrenadorNotFoundException;
    Entrenador save(Entrenador entrenador);
}
