package com.certant.pokedexliteengrupo.seguridad.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rol {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol;

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId_rol() {
        return id_rol;
    }

    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
    }

}
