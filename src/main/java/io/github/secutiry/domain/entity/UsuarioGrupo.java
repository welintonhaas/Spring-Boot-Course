package io.github.secutiry.domain.entity;

import jakarta.persistence.*;

public class UsuarioGrupo
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private Long id;

	private String nome;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_grupo")
	private Grupo grupo;
}
