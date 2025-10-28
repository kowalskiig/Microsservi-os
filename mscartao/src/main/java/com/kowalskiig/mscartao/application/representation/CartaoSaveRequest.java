package com.kowalskiig.mscartao.application.representation;

import com.kowalskiig.mscartao.domain.BandeiraCartao;
import com.kowalskiig.mscartao.domain.Cartao;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CartaoSaveRequest {

    private String nome;
    private BandeiraCartao bandeiraCartao;
    private BigDecimal renda;
    private BigDecimal limiteBasico;

    public Cartao toModel(){
        return new Cartao(nome, bandeiraCartao, renda, limiteBasico);
    }

}
