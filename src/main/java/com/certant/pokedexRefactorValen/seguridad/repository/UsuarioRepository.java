package com.certant.pokedexRefactorValen.seguridad.repository;

import com.certant.pokedexRefactorValen.seguridad.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Usuario findByUsername(String username);
}
