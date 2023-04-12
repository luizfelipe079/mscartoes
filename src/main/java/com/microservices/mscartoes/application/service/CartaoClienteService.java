package com.microservices.mscartoes.application.service;

import com.microservices.mscartoes.domain.ClienteCartao;

import java.util.List;

public interface CartaoClienteService {

    List<ClienteCartao> listaCartoesByCpf(String cpf);
}
