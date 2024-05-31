package io.github.secutiry.domain.repository;

import io.github.secutiry.domain.entity.Usuario;
import io.github.secutiry.domain.entity.UsuarioGrupo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioGrupoRepository extends JpaRepository<UsuarioGrupo, String>
{
	@Query("""
		select distinct g.nome
		from UsuarioGrupo ug
		join ug.grupo g
		join ug.usuario u
		where u = ?1
	""")
	List<String> findPermissoesByUsuario(Usuario usuario);
}
