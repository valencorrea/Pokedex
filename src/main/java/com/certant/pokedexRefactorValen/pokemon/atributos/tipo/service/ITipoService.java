package com.certant.pokedexRefactorValen.pokemon.atributos.tipo.service;

import com.certant.pokedexRefactorValen.pokemon.atributos.tipo.entity.Tipo;
import com.certant.pokedexRefactorValen.pokemon.atributos.tipo.exception.TipoNotFoundException;

import java.util.List;

public interface ITipoService {
    List<Tipo> findAll();
    Tipo findById(Long id) throws TipoNotFoundException;
    void deleteById(Long id)throws TipoNotFoundException;
    boolean existsById (Long id);
    Tipo save (Tipo tipo);
    Tipo update (Tipo tipo);
}
