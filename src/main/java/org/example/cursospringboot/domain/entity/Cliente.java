package org.example.cursospringboot.domain.entity;

public class Cliente
{
	private Integer id;
	private String nome;

	public Cliente(String nome)
	{
		this.nome = nome;
	}

	public Cliente(Integer id, String nome)
	{
		this.id = id;
		this.nome = nome;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	@Override
	public String toString()
	{
		return "Cliente{" + "nome='" + nome + '\'' + ", id=" + id + '}';
	}
}
