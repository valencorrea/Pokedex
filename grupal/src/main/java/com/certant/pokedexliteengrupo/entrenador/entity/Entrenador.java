package com.certant.pokedexliteengrupo.entrenador.entity;

import com.certant.pokedexliteengrupo.pokemon.atributos.pokemonenentrenamiento.entity.PokemonEnEntrenamiento;
import com.certant.pokedexliteengrupo.pokemon.atributos.pokemonenentrenamiento.exceptions.PokemonEntrenamientoNotFound;
import com.certant.pokedexliteengrupo.pokemon.exception.PokemonNotFoundException;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "entrenadores")
public class Entrenador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;

@OneToMany(mappedBy = "entrenador")
private List<PokemonEnEntrenamiento> pokemonsEnEntrenamiento;

    public Entrenador(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Entrenador() {
    }

    public List<PokemonEnEntrenamiento> getPokemonsEntrenamiento() {
        return this.pokemonsEnEntrenamiento;
    }

    public void setPokemonsEntrenamiento(List<PokemonEnEntrenamiento> pokemonsEnEntrenamiento){
        this.pokemonsEnEntrenamiento = pokemonsEnEntrenamiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entrenador that = (Entrenador) o;
        return id.equals(that.id) && nombre.equals(that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    private static final long serialVersionUID = 1L;
}
