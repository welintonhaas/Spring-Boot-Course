package io.github.secutiry.api.dto;

import io.github.secutiry.domain.entity.Usuario;
import java.util.List;
import lombok.Data;

@Data
public class CadastroUsuarioDTO
{
	private Usuario usuario;
	private List<String> permissoes;

}
