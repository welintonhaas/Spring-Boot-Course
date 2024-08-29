package org.example.cursospringboot.repository;

import java.util.List;
import org.example.cursospringboot.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Cliente, Integer>
{

	List<Cliente> findByNomeLike(String nome);

	List<Cliente> findByNomeOrIdOrderByIdDesc(String nome, Integer id);

	Cliente findOneByNome(String nome);

	boolean existsByNome(String nome);

}
