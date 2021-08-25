package com.certant.pokedexliteengrupo.pokemon.entity;

import com.certant.pokedexliteengrupo.pokemon.atributos.evolucionaa.entity.EvolucionaA;
import com.certant.pokedexliteengrupo.pokemon.atributos.habilidad.entity.Habilidad;
import com.certant.pokedexliteengrupo.pokemon.atributos.pokemonenentrenamiento.entity.PokemonEnEntrenamiento;
import com.certant.pokedexliteengrupo.pokemon.atributos.tipo.entity.Tipo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pokemones")
public class Pokemon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    private Integer nivel;

    @OneToOne(mappedBy = "pokemonInicial")
    private EvolucionaA evolucionaA;

    @OneToOne(mappedBy = "pokemonEvolucion")
    private EvolucionaA esEvolucionDe;

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

    @OneToMany(mappedBy = "pokemon")
    private List<PokemonEnEntrenamiento> pokemonsEnEntrenamiento;

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
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

    public Set<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Set<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    public Set<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(Set<Tipo> tipos) {
        this.tipos = tipos;
    }

    public EvolucionaA getEvolucionaA() {
        return evolucionaA;
    }

    public void setEvolucionaA(EvolucionaA evolucionaA) {
        this.evolucionaA = evolucionaA;
    }

    public EvolucionaA getEsEvolucionDe() {
        return esEvolucionDe;
    }

    public void setEsEvolucionDe(EvolucionaA esEvolucionDe) {
        this.esEvolucionDe = esEvolucionDe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon that = (Pokemon) o;
        return id.equals(that.id) && nombre.equals(that.nombre);
    }

    private static final long serialVersionUID = 1L;
}
