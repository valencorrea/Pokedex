package com.certant.pokedexRefactorValen.pokemon.atributos.tipo.service;

import com.certant.pokedexRefactorValen.pokemon.atributos.tipo.entity.Tipo;
import com.certant.pokedexRefactorValen.pokemon.atributos.tipo.exception.TipoNotFoundException;
import com.certant.pokedexRefactorValen.pokemon.atributos.tipo.exception.TipoNullPointerException;
import com.certant.pokedexRefactorValen.pokemon.atributos.tipo.repository.ITipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TipoService implements ITipoService {
    @Autowired
    ITipoRepository tipoRepository;

    @Override
    public List<Tipo> findAll() {
        return (List<Tipo>) tipoRepository.findAll();
    }

    @Override
    public Tipo findById(Long id) throws TipoNotFoundException {
        if(!existsById(id)){
            throw new TipoNotFoundException("Id not found");
        }
        Optional<Tipo> tipo = tipoRepository.findById(id);
        if (tipo.isEmpty())
            throw new TipoNotFoundException("Tipo not found");
        return tipo.get();
    }

    @Override
    public void deleteById (Long id) throws TipoNotFoundException{
        if(!existsById(id)){
            throw new TipoNotFoundException("Id not found");
        }
        tipoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        if(id==null){
            return false;
        }
        return tipoRepository.existsById(id);
    }

    @Override
    public Tipo save(Tipo tipo) {
        return tipoRepository.save(tipo);
    }

    @Override
    public Tipo update(Tipo tipo) {
        if(tipo.getNombre()==null || tipo.getNombre().isEmpty()){
            throw new TipoNullPointerException("Nombre no valido");
        }
        return tipoRepository.save(tipo);
    }
    
}
