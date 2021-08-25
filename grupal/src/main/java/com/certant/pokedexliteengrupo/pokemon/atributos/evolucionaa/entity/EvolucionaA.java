package com.certant.pokedexliteengrupo.pokemon.atributos.evolucionaa.entity;

import com.certant.pokedexliteengrupo.pokemon.entity.Pokemon;

import javax.persistence.*;

@Entity
@Table(name = "evoluciona_a")
public class EvolucionaA {

    @Id
    private Long id;

    @MapsId
    @JoinColumn(name = "pokemon_inicial_id",unique = true)
    @OneToOne()
    private Pokemon pokemonInicial;

    @MapsId
    @JoinColumn(name = "pokemon_evolucion_id",unique = true)
    @OneToOne()
    private Pokemon pokemonEvolucion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pokemon getPokemonInicial() {
        return pokemonInicial;
    }

    public void setPokemonInicial(Pokemon pokemonInicial) {
        this.pokemonInicial = pokemonInicial;
    }

    public Pokemon getPokemonEvolucion() {
        return pokemonEvolucion;
    }

    public void setPokemonEvolucion(Pokemon pokemonEvolucion) {
        this.pokemonEvolucion = pokemonEvolucion;
    }
}
