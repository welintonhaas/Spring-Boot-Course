package io.github.secutiry.domain.entity;

import jakarta.persistence.*;

public class Grupo
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private Long id;
	private String nome;
}
