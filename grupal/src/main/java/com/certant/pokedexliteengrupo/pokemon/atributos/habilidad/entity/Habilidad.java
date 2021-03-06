package com.certant.pokedexliteengrupo.pokemon.atributos.habilidad.entity;

import com.certant.pokedexliteengrupo.pokemon.entity.Pokemon;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "habilidades")
public class Habilidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;

    @ManyToMany(mappedBy = "habilidades")
    private Set<Pokemon> pokemones;

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

    public Set<Pokemon> getPokemones() {
        return pokemones;
    }

    public void setPokemones(Set<Pokemon> pokemones) {
        this.pokemones = pokemones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habilidad that = (Habilidad) o;
        return id.equals(that.id) && nombre.equals(that.nombre);
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }*/

    private static final long serialVersionUID = 1L;
}

