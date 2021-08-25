package com.certant.pokedexliteengrupo.seguridad.repository;

import com.certant.pokedexliteengrupo.seguridad.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Usuario findByUsername(String username);
}
