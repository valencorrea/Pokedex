package com.certant.pokedexliteengrupo.seguridad.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    private String username;

    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private List<Rol> roles;

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}
