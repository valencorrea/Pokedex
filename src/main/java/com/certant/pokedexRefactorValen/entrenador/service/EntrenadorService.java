package com.certant.pokedexRefactorValen.entrenador.service;

import com.certant.pokedexRefactorValen.entrenador.entity.Entrenador;
import com.certant.pokedexRefactorValen.entrenador.exceptions.EntrenadorInvalidIdException;
import com.certant.pokedexRefactorValen.entrenador.exceptions.EntrenadorInvalidNameException;
import com.certant.pokedexRefactorValen.entrenador.exceptions.EntrenadorInvalidPointerException;
import com.certant.pokedexRefactorValen.entrenador.exceptions.EntrenadorNotFoundException;
import com.certant.pokedexRefactorValen.entrenador.repository.IEntrenadorRepository;
import com.certant.pokedexRefactorValen.pokemon.exceptions.PokemonInvalidNameException;
import com.certant.pokedexRefactorValen.pokemon.exceptions.PokemonInvalidPointerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorService implements IEntrenadorService{

    @Autowired
    IEntrenadorRepository entrenadorRepository;

    @Override
    public List<Entrenador> findAll() {
        return (List<Entrenador>) entrenadorRepository.findAll();
    }

    @Override
    public boolean existsById(Long id) throws Throwable {
        validarId(id);
        return entrenadorRepository.existsById(id);
    }

    @Override
    public Entrenador findById(Long id) throws Throwable {
        validarId(id);
        if(!existsById(id))
            throw new EntrenadorNotFoundException("No existe el ID del entrenador solicitado en la base de datos");

        Optional<Entrenador> entrenador = entrenadorRepository.findById(id);
        return entrenador.get();
    }

    @Override
    public void deleteById(Long id) throws Throwable {
        validarId(id);
        if(!existsById(id))
            throw new EntrenadorNotFoundException("No existe el ID del entrenador solicitado en la base de datos");

        entrenadorRepository.deleteById(id);
    }

    @Override
    public Entrenador save(Entrenador entrenador) throws Throwable {
        validarEntrenador(entrenador);
        return entrenadorRepository.save(entrenador);
    }

    private void validarEntrenador(Entrenador entrenador) throws Throwable {
        if (entrenador == null)
            throw new EntrenadorInvalidPointerException("No se puede trabajar con una direccion de memoria invalida");

        if(entrenador.getNombre() == null)
            throw new EntrenadorInvalidNameException("No se puede trabajar con un nombre invalido");

        if (entrenador.getNombre().isEmpty())
            throw new EntrenadorInvalidNameException("No se puede trabajar con un nombre invalido");
    }

    private void validarId(Long id) throws Throwable {
        if(id == null)
            throw new EntrenadorInvalidIdException("No se puede trabajar con IDs null");

        if(id < 0)
            throw new EntrenadorInvalidIdException("No se puede trabajar con IDs negativos");
    }


}
