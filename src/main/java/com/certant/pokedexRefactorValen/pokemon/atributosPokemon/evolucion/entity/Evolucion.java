package com.certant.pokedexRefactorValen.pokemon.atributosPokemon.evolucion.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "evoluciones")
public class Evolucion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    private Long nivelNecesario;
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNivelNecesario() {
        return nivelNecesario;
    }

    public void setNivelNecesario(Long nivelNecesario) {
        this.nivelNecesario = nivelNecesario;
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
        Evolucion that = (Evolucion) o;
        return id.equals(that.id) && nombre.equals(that.nombre) && nivelNecesario.equals(that.nivelNecesario);
    }

}