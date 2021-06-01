package com.certant.pokedexRefactorValen.pokemon.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

// proporciona los metodos get y set para cada atributo
@Data
@Entity
@Table(name = "pokemones")
public class Pokemon implements Serializable {

    // le indico que esta es la llave primaria
    @Id
    // el nombre en el sql
    @Column(name = "id_pokemon")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre_pokemon", nullable = false)
    private String nombre;

    @Column(name="nivel_de_arribo")
    private Long nivel;
    private static final long serialVersionUID = 1L;

    // es buena practica redefinir el metodo
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon that = (Pokemon) o;
        return id.equals(that.id) && nombre.equals(that.nombre) && nivel.equals(that.nivel);
    }
}
