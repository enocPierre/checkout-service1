package com.mscompra.mscompra.controller;

import com.mscompra.mscompra.model.Pedido;
import com.mscompra.mscompra.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    // as acao de pedido-
    @PostMapping
    public ResponseEntity<Pedido> salvar(@RequestBody Pedido pedido) {
        return ResponseEntity.ok(pedidoService.salvar(pedido));
    }
 }
