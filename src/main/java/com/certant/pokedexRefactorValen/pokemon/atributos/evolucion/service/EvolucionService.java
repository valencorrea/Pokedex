package com.certant.pokedexRefactorValen.pokemon.atributos.evolucion.service;

import com.certant.pokedexRefactorValen.pokemon.atributos.evolucion.entity.Evolucion;
import com.certant.pokedexRefactorValen.pokemon.atributos.evolucion.exceptions.EvolucionInvalidIdException;
import com.certant.pokedexRefactorValen.pokemon.atributos.evolucion.exceptions.EvolucionNotFoundException;
import com.certant.pokedexRefactorValen.pokemon.atributos.evolucion.exceptions.EvolucionNullPointerException;
import com.certant.pokedexRefactorValen.pokemon.atributos.evolucion.repository.IEvolucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class EvolucionService implements IEvolucionService{
    @Autowired
    IEvolucionRepository evolucionRepository;

    @Override
    public List<Evolucion> findAll() {
        return (List<Evolucion>) evolucionRepository.findAll();
    }

    @Override
    public Evolucion findById(Long id) throws Throwable {
        if(!existsById(id)){
            throw new EvolucionNotFoundException("Id not found");
        }
        Optional<Evolucion> evolucion = evolucionRepository.findById(id);
        if (evolucion.isEmpty())
            throw new EvolucionNotFoundException("Ability not found");
        return evolucion.get();
    }

    @Override
    public void deleteById(Long id) throws Throwable {
        if(!existsById(id)){
            throw new EvolucionNotFoundException("Id not found");
        }
        evolucionRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) throws Throwable {
        if((id==null) || (id<0)){
            throw new EvolucionInvalidIdException("Invalid ID");
        }
        return evolucionRepository.existsById(id);
    }

    @Override
    public Evolucion save(Evolucion evolucion) {
        return evolucionRepository.save(evolucion);
    }

    @Override
    public Evolucion update(Evolucion evolucion) throws Throwable {
            if(evolucion.getNombre()==null || evolucion.getNombre().isEmpty()){
                throw new EvolucionNullPointerException("Nombre no valido");
            }
            return evolucionRepository.save(evolucion);
        }
}
