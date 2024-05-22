package io.github.secutiry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
	@Bean
	public SecurityFilterChain filterChain(
		HttpSecurity http, SenhaMasterAuthenticationProvider senhaMasterAuthenticationProvider) throws Exception
	{
		return http.authorizeHttpRequests(customizer -> {
			customizer.requestMatchers("/public").permitAll();
				customizer.anyRequest().authenticated();
			})
			.httpBasic(Customizer.withDefaults())
			.formLogin(Customizer.withDefaults())
			.authenticationProvider(senhaMasterAuthenticationProvider)
			.build();
	}

	@Bean
	public UserDetailsService userDetailsService(){
		UserDetails user = User.builder()
			.username("user")
			.password(passwordEncoder().encode("123"))
			.roles("USER")
			.build();
		UserDetails admin = User.builder()
			.username("admin")
			.password(passwordEncoder().encode("123"))
			.roles("ADMIN")
			.build();

		return new InMemoryUserDetailsManager(user, admin);
	}

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

}
