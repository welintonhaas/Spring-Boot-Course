package io.github.secutiry.domain.repository;

import io.github.secutiry.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String>
{
}
