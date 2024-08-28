package org.example.cursospringboot.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.example.cursospringboot.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class Clientes
{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private EntityManager entityManager;

	@Transactional
	public void salvar(Cliente cliente){
		entityManager.persist(cliente);
	}

	@Transactional
	public void atualizar(Cliente cliente){
		entityManager.merge(cliente);
	}

	@Transactional
	public void deletar(Cliente cliente){
		if (!entityManager.contains(cliente)){
			cliente = entityManager.merge(cliente);
		}
		entityManager.remove(cliente);
	}

	@Transactional
	public void deletar(Integer id){
		Cliente cliente = entityManager.find(Cliente.class, id);
		deletar(cliente);
	}

	@Transactional(readOnly = true)
	public List<Cliente>obterPorNome(String nome){
		String jpql = "select c from Cliente c where c.nome like :nome";
		TypedQuery<Cliente> query = entityManager
			.createQuery(jpql, Cliente.class)
			.setParameter("nome", "%"+nome+"%");
		return query.getResultList();
	}

	public List<Cliente>obterTodos(){
		return entityManager
			.createQuery("from Cliente",Cliente.class)
			.getResultList();
	}
}
