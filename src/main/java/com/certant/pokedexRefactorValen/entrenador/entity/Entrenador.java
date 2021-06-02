package com.certant.pokedexRefactorValen.entrenador.entity;

import com.certant.pokedexRefactorValen.pokemon.entity.Pokemon;
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
    private static final long serialVersionUID = 1L;

    @OneToMany
    @JoinTable(
            name = "entrenador_pokemones",
            joinColumns = {@JoinColumn(name = "entrenador_id")},
            inverseJoinColumns = {@JoinColumn(name = "pokemon_id")}
    )
    private List<Pokemon> pokemones;

    public List<Pokemon> getPokemones() {
        return this.pokemones;
    }

    public void setPokemones(List<Pokemon> pokemones){
        this.pokemones = pokemones;
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

}