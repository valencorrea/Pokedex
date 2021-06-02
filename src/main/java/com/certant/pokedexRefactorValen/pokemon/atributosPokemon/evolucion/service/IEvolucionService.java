package com.certant.pokedexRefactorValen.pokemon.atributosPokemon.evolucion.service;

import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.evolucion.entity.Evolucion;
import java.util.List;

public interface IEvolucionService {

    List<Evolucion> findAll();

}
