package io.github.secutiry.domain.security;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomAuthentication implements Authentication
{

	private final IdentificacaoUsuario indentificacaoUsuario;

	public CustomAuthentication(IdentificacaoUsuario indentificacaoUsuario)
	{
		if (indentificacaoUsuario == null)
		{
			throw new ExceptionInInitializerError("Não é possível criar um usuário sem indentificação do usuário");		}
		this.indentificacaoUsuario = indentificacaoUsuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return this.indentificacaoUsuario
			.getPermissoes()
			.stream()
			.map(SimpleGrantedAuthority::new)
			.collect(Collectors.toList());
	}

	@Override
	public Object getCredentials()
	{
		return null;
	}

	@Override
	public Object getDetails()
	{
		return null;
	}

	@Override
	public Object getPrincipal()
	{
		return this.indentificacaoUsuario;
	}

	@Override
	public boolean isAuthenticated()
	{
		return true;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException
	{
		throw new IllegalArgumentException("Não é possível alterar o estado de autenticação");
	}

	@Override
	public String getName()
	{
		return this.indentificacaoUsuario.getNome();
	}
}
