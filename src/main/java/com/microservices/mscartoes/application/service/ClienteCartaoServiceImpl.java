package com.microservices.mscartoes.application.service;

import com.microservices.mscartoes.domain.ClienteCartao;
import com.microservices.mscartoes.infra.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoServiceImpl implements CartaoClienteService{

    private final ClienteCartaoRepository repository;

    public List<ClienteCartao> listaCartoesByCpf(String cpf){
        return repository.findByCpf(cpf);
    }
}
