package io.github.secutiry.api;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController
{
	@GetMapping("/public")
	public String publicEndpoint()
	{
		return "public route ok";
	}

	@GetMapping("/private")
	public String privateEndpoint(Authentication authentication)
	{
		System.out.println(authentication.getClass());
		return "private route ok ! Usuário autenticado: " + authentication.getName();
	}
}
