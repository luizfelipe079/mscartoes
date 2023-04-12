package com.microservices.mscartoes.application.controllers;

import com.microservices.mscartoes.application.service.CartaoClienteService;
import com.microservices.mscartoes.application.service.CartaoService;
import com.microservices.mscartoes.domain.Cartao;
import com.microservices.mscartoes.domain.CartoesPorClienteResponse;
import com.microservices.mscartoes.domain.ClienteCartao;
import com.microservices.mscartoes.dto.CartaoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cartoes")
@RequiredArgsConstructor
public class CartoesController {

    private final CartaoService cartaoService;

    private final CartaoClienteService cartaoClienteService;

    @GetMapping(path = "status")
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity cadastra(@RequestBody CartaoRequest request){
        Cartao cartao = request.toModel();
        cartaoService.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Cartao>> getCartoesRendaAte(@RequestParam("renda") Long renda){
        List<Cartao> cartoes = cartaoService.getCartoesRendaMenorIgual(renda);
        return ResponseEntity.ok(cartoes);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesPorClienteResponse>> getCartaoByCliente(@RequestParam("cpf") String cpf){
        List<ClienteCartao> clienteCartaos = cartaoClienteService.listaCartoesByCpf(cpf);
        List<CartoesPorClienteResponse> resultList = clienteCartaos
                .stream()
                .map(CartoesPorClienteResponse::fromModel)
                .toList();
        return ResponseEntity.ok(resultList);
    }
}
