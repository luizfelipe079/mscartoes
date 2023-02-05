package com.microservices.mscartoes.dto;

import com.microservices.mscartoes.domain.BandeiraCartao;
import com.microservices.mscartoes.domain.Cartao;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoRequest {

    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limite;

    public Cartao toModel(){
        return new Cartao(null, nome, bandeira, renda, limite);
    }
}
