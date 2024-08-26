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
			clientes.salvar(
				new Cliente("Fulano")
			);

			clientes.salvar(
				new Cliente("Ciclano")
			);

			List<Cliente> todosClientes = clientes.obterTodos();
			todosClientes.forEach(msg -> log.info(msg.toString()));
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
