package org.example.cursospringboot;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
import org.example.cursospringboot.domain.entity.Cliente;
import org.example.cursospringboot.domain.entity.Pedido;
import org.example.cursospringboot.repository.ClientesRepository;
import org.example.cursospringboot.repository.PedidosRepository;
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
    public CommandLineRunner init(
            @Autowired ClientesRepository clientes,
            @Autowired PedidosRepository pedidos
	){
		return args -> {

			Cliente fulano = clientes.save(
				new Cliente("Fulano")
			);

			Pedido p = new Pedido();
			p.setCliente(fulano);
			p.setDataPedido(LocalDate.now());
			p.setTotal(BigDecimal.valueOf(100));

			pedidos.save(p);

			/*Cliente cliente = clientes.findClienteFetchPedidos(fulano.getId());
			log.info(cliente.toString());
			log.info(cliente.getPedidos().toString());*/

			pedidos.findByCliente(fulano).forEach(c -> log.info(c.toString()));
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
