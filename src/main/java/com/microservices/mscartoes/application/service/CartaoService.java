package com.microservices.mscartoes.application.service;

import com.microservices.mscartoes.domain.Cartao;

import java.util.List;

public interface CartaoService {
    Cartao save(Cartao cartao);
    List<Cartao> getCartoesRendaMenorIgual(Long renda);
}
