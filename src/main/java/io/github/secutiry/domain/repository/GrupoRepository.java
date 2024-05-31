package io.github.secutiry.domain.repository;

import io.github.secutiry.domain.entity.Grupo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoRepository extends JpaRepository<Grupo, String>
{
	Optional<Grupo> findByNome(String nome);
}
