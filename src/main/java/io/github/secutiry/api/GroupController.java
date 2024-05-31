package io.github.secutiry.api;

import io.github.secutiry.domain.entity.Grupo;
import io.github.secutiry.domain.repository.GrupoRepository;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grupos")
@RequiredArgsConstructor
public class GroupController
{
	private final GrupoRepository repository;

	@PostMapping
	@Transactional
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Grupo> salvar(@RequestBody Grupo grupo){
		repository.save(grupo);
		return ResponseEntity.ok(grupo);
	}

	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Grupo>> listar(){
		return ResponseEntity.ok(repository.findAll());
	}
}
