package org.example.cursospringboot;

import java.util.List;
import java.util.logging.Logger;
import org.example.cursospringboot.domain.entity.Cliente;
import org.example.cursospringboot.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VendasApplication
{

	Logger log = Logger.getLogger(VendasApplication.class.getName());

	@Bean
	public CommandLineRunner init(@Autowired ClientesRepository clientes){
		return args -> {

			String nomeCliente1 = "Fulano";
			log.info("Salavando Clientes");
			clientes.save(
				new Cliente(nomeCliente1)
			);

			clientes.save(
				new Cliente("Ciclano")
			);

			log.info("Obtendo todos Clientes");
			List<Cliente> todosClientes = clientes.findAll();
			todosClientes.forEach(msg -> log.info(msg.toString()));

			boolean existe = clientes.existsByNome(nomeCliente1);
			log.info("Exite um cliente com o nome "+nomeCliente1+"? "+existe);

			log.info("Alterando Clientes");
			todosClientes.forEach(c -> {
				c.setNome(c.getNome()+" Alterado");
				clientes.save(c);
			});

			log.info("Buscando por "+nomeCliente1);
			clientes.encontrarPorNome("Ful%").forEach(msg -> log.info(msg.toString()));

			boolean existeAinda = clientes.existsByNome(nomeCliente1);
			log.info("Exite um cliente com o nome "+nomeCliente1+"? "+existeAinda);

			log.info("Deletando Clientes");
            clientes.deleteAll(todosClientes);

			log.info("Obtendo todos Clientes");
			todosClientes = clientes.findAll();

			if (todosClientes.isEmpty())
			{
				log.info("Nenhum cliente encontrado");
			}
			else
			{
				todosClientes.forEach(msg -> log.info(msg.toString()));
			}


		};
	}

	@Value("${spring.application.name}")
	private String applicationName;

	@GetMapping("/hello")
	public String helloWorld(){
		return applicationName;
	}

	public static void main(String[] args)
	{
		SpringApplication.run(VendasApplication.class, args);
	}
}
