package io.github.secutiry.domain.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class Usuario
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String login;
	private String senha;
	private String nome;

	@Transient
	private List<String> permissoes;
}
