package com.certant.pokedexRefactorValen.pokemon.atributos.evolucion.service;

import com.certant.pokedexRefactorValen.pokemon.atributos.evolucion.entity.Evolucion;
import java.util.List;

public interface IEvolucionService {

    List<Evolucion> findAll();

}
