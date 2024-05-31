package io.github.secutiry.config;

import java.util.List;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
			return new UsernamePasswordAuthenticationToken
				("Sou Master", null, List.of(new SimpleGrantedAuthority("ADMIN")));
		}

		return null;
	}

	@Override
	public boolean supports(Class<?> authentication)
	{
		return true;
	}
}
