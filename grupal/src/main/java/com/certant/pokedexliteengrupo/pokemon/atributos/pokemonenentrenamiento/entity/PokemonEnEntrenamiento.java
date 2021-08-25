package com.certant.pokedexliteengrupo.pokemon.atributos.pokemonenentrenamiento.entity;

import com.certant.pokedexliteengrupo.entrenador.entity.Entrenador;
import com.certant.pokedexliteengrupo.pokemon.entity.Pokemon;

import javax.persistence.*;

@Entity
@Table(name = "pokemon_en_entrenamiento")
public class PokemonEnEntrenamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer nivelActual;

    @ManyToOne
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;

    @ManyToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNivelActual() {
        return nivelActual;
    }

    public void setNivelActual(Integer nivelActual) {
        this.nivelActual = nivelActual;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
}
