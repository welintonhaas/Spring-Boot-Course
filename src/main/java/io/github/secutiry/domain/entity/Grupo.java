package io.github.secutiry.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Grupo
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String nome;
}
