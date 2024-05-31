package io.github.secutiry.domain.service;

import io.github.secutiry.domain.entity.Grupo;
import io.github.secutiry.domain.entity.Usuario;
import io.github.secutiry.domain.entity.UsuarioGrupo;
import io.github.secutiry.domain.repository.GrupoRepository;
import io.github.secutiry.domain.repository.UsuarioGrupoRepository;
import io.github.secutiry.domain.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService
{
	private final UsuarioRepository usuarioRepository;
	private final GrupoRepository grupoRepository;
	private final UsuarioGrupoRepository usuarioGrupoRepository;

	@Transactional
	public Usuario salvar(Usuario usuario, List<String> grupos)
	{
		usuarioRepository.save(usuario);

		List<UsuarioGrupo> listaUsuarioGrupo = grupos.stream().map(nomeGrupo -> {
			Optional<Grupo> possivelGrupo = grupoRepository.findByNome(nomeGrupo);
			if (possivelGrupo.isPresent())
			{
				Grupo grupo = possivelGrupo.get();
				return new UsuarioGrupo(usuario, grupo);
			}
			return null;
		}).filter(grupo -> grupo != null).collect(Collectors.toList());

		usuarioGrupoRepository.saveAll(listaUsuarioGrupo);

		return usuario;
	}
}
