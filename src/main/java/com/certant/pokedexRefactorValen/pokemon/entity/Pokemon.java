package com.certant.pokedexRefactorValen.pokemon.entity;

import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.evolucion.entity.Evolucion;
import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.habilidad.entity.Habilidad;
import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.tipo.entity.Tipo;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "pokemones")
public class Pokemon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    private Integer nivel;
    private static final long serialVersionUID = 1L;

    /* Tablas para las relaciones en el h2-console bbdd */
    @ManyToMany
    @JoinTable(
            name = "pokemon_habilidad",
            joinColumns = {@JoinColumn(name = "pokemon_id")},
            inverseJoinColumns = {@JoinColumn(name = "habilidad_id")}
    )
    private Set<Habilidad> habilidades;

    @ManyToMany
    @JoinTable(
            name = "pokemon_tipo",
            joinColumns = {@JoinColumn(name = "pokemon_id")},
            inverseJoinColumns = {@JoinColumn(name = "tipo_id")}
    )
    private Set<Tipo> tipos;

    @ManyToMany
    @JoinTable(
            name = "pokemon_evolucion",
            joinColumns = {@JoinColumn(name = "pokemon_id")},
            inverseJoinColumns = {@JoinColumn(name = "evolucion_id")}
    )
    private Set<Evolucion> evoluciones;

    // es buena practica redefinir los metodos
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
        Pokemon that = (Pokemon) o;
        return id.equals(that.id) && nombre.equals(that.nombre) && nivel.equals(that.nivel);
    }
}
