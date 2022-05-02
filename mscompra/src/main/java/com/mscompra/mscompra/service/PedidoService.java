package com.mscompra.mscompra.service;

import com.mscompra.mscompra.model.Pedido;
import com.mscompra.mscompra.repository.PedidoRepository;
import com.mscompra.mscompra.service.rabbitmq.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final Producer producer;

    public Pedido salvar(Pedido pedido) {
        pedido = pedidoRepository.save(pedido);
        producer.enviarPedido(pedido);
       return  pedido;
    }
}
