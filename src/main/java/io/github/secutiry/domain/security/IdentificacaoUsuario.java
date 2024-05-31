package io.github.secutiry.domain.security;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IdentificacaoUsuario
{
	private Long id;
	private String nome;
	private String login;
	private List<String> permissoes;

	public IdentificacaoUsuario(Long id, String nome, String login, List<String> permissoes)
	{
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.permissoes = permissoes;
	}

	public List<String> getPermissoes()
	{
		if (permissoes == null)
		{
			permissoes = List.of();
		}
		return permissoes;
	}
}
