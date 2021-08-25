package com.certant.pokedexliteengrupo.pokemon.atributos.evolucionaa.service;

import com.certant.pokedexliteengrupo.pokemon.atributos.evolucionaa.entity.EvolucionaA;
import com.certant.pokedexliteengrupo.pokemon.entity.Pokemon;
import com.certant.pokedexliteengrupo.pokemon.repository.IPokemonRepository;
import com.certant.pokedexliteengrupo.pokemon.service.IPokemonService;
import com.certant.pokedexliteengrupo.pokemon.service.PokemonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

@DataJpaTest
@ComponentScan
class EvolucionaAServiceTest {

    @Autowired
    IPokemonRepository pokemonRepository;

    @Autowired
    IEvolucionaAService evolucionaAService;

    @Test
    void save() {

        EvolucionaA evolucionaA = new EvolucionaA();
        // 13 -> 14
        evolucionaA.setPokemonInicial(pokemonRepository.findById(13L).get());
        evolucionaA.setPokemonEvolucion(pokemonRepository.findById(14L).get());
        evolucionaA=evolucionaAService.save(evolucionaA);
        System.out.println(evolucionaA);
    }
}