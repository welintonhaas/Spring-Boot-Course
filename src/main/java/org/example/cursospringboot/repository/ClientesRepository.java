package org.example.cursospringboot.repository;


import java.util.List;
import org.example.cursospringboot.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ClientesRepository
{
	private static final String INSERT_SQL = "INSERT INTO CLIENTE (NOME) VALUES (?)";
	private static final String SELECT_ALL = "SELECT * FROM CLIENTE";
	private static final String DELETE_SQL = "DELETE FROM CLIENTE WHERE ID = ?";
	private static final String UPDATE_SQL = "UPDATE CLIENTE SET NOME = ? WHERE ID = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void salvar(Cliente cliente){
		jdbcTemplate.update(INSERT_SQL, cliente.getNome());
	}

	public Cliente atualizar(Cliente cliente){
		jdbcTemplate.update(UPDATE_SQL, cliente.getNome(), cliente.getId());
		return cliente;
	}

	public void deletar(Cliente cliente){
		jdbcTemplate.update(DELETE_SQL, cliente.getId());
	}

	public void deletar(Integer id){
		jdbcTemplate.update(DELETE_SQL, id);
	}

	public List<Cliente>obterPorNome(String nome){
		return jdbcTemplate.query(SELECT_ALL.concat(" WHERE NOME LIKE ?"), obterClienteMapper(),
			"%"+nome+"%");
	}

	private static RowMapper<Cliente> obterClienteMapper()
	{
		return (rs, rowNum) -> {
			Integer id = rs.getInt("ID");
			String nome = rs.getString("NOME");
			return new Cliente(id, nome);
		};
	}

	public List<Cliente>obterTodos(){
		return jdbcTemplate.query(SELECT_ALL, obterClienteMapper());
	}
}
