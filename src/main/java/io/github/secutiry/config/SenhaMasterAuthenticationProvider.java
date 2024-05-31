package io.github.secutiry.config;

import io.github.secutiry.domain.security.CustomAuthentication;
import io.github.secutiry.domain.security.IdentificacaoUsuario;
import java.util.List;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class SenhaMasterAuthenticationProvider implements AuthenticationProvider
{
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException
	{
		var login = authentication.getName();
		var senha = authentication.getCredentials();

		String loginMaster = "master";
		String senhaMaster = "master";

		if (loginMaster.equals(login) && senhaMaster.equals(senha))
		{
			IdentificacaoUsuario identificacaoUsuario = new IdentificacaoUsuario(
				"id-Master",
				"Master",
				loginMaster,
				List.of("ADMIN")
			);
			return new CustomAuthentication(identificacaoUsuario);
		}

		return null;
	}

	@Override
	public boolean supports(Class<?> authentication)
	{
		return true;
	}
}
