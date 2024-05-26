package io.github.secutiry.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController
{
	@GetMapping("/public")
	public ResponseEntity<String> publicRoute()
	{
		return ResponseEntity.ok("public route ok");
	}

	@GetMapping("/private")
	public ResponseEntity<String> privateRoute(Authentication authentication)
	{
		System.out.println(authentication.getClass());
		return ResponseEntity.ok("private route ok ! Usário autenticado: " + authentication.getName());
	}

	@GetMapping("/admin")
	public ResponseEntity<String> adminRoute(Authentication authentication)
	{
		System.out.println(authentication.getClass());
		return ResponseEntity.ok("Admin Route Ok!");
	}
}
