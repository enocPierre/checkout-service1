package com.workercompras.consumer;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.workercompras.model.Pedido;
import com.workercompras.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class Consumer {

    private final ObjectMapper mapper;
    private final EmailService emailService;

    @RabbitListener(queues = {"${queue.name}"})
    public void consumer(@Payload  Message message) throws IOException {
        var pedido = mapper.readValue(message.getBody(), Pedido.class);
       // System.out.println("Mensagem recebid no WorkerCompras: " + pedido);
        log.info("Pedido recebido: {}", pedido);
        emailService.notificarCliente(pedido.getEmail());
         //emailService.notificarCliente("evandeci.purificao@gmail.com");
    }
}
