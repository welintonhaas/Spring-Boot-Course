package io.github.secutiry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		return http.authorizeHttpRequests(customizer -> {
			customizer.requestMatchers("/public").permitAll();
				customizer.anyRequest().authenticated();
			})
			.httpBasic(Customizer.withDefaults()).build();
	}
}
