package io.github.secutiry.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UsuarioGrupo
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	private String nome;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_grupo")
	private Grupo grupo;
}
