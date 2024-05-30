package io.github.secutiry.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Usuario
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private Long id;
	private String login;
	private String senha;
	private String nome;
}
