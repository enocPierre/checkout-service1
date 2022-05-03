package com.mscompra.mscompra.service.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mscompra.mscompra.model.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.Serializable;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class Producer implements Serializable {
    private static final long serialVersionUID = 1L;

    //@Autowired
    private final RabbitTemplate rabbitTemplate;
   // @Autowired
    private final Queue queue;
    private final ObjectMapper mapper;

    //@PostMapping
    @SneakyThrows
    public void enviarPedido(Pedido pedido) {
        rabbitTemplate.convertAndSend(queue.getName(), mapper.writeValueAsString(pedido));
    }
}
