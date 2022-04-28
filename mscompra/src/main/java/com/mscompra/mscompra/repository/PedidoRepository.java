package com.mscompra.mscompra.repository;

import com.mscompra.mscompra.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
