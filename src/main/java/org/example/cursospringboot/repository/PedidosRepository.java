package org.example.cursospringboot.repository;

import org.example.cursospringboot.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepository extends JpaRepository<Pedido, Integer> {
}
