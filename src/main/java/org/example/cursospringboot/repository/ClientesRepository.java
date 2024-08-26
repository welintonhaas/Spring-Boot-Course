package org.example.cursospringboot.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
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

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void salvar(Cliente cliente){
		jdbcTemplate.update(INSERT_SQL, cliente.getNome());
	}

	public List<Cliente>obterTodos(){
		return jdbcTemplate.query(SELECT_ALL, new RowMapper<Cliente>()
		{
			@Override
			public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				Integer id = rs.getInt("ID");
				String nome = rs.getString("NOME");
				return new Cliente(id, nome);
			}
		});
	}
}
