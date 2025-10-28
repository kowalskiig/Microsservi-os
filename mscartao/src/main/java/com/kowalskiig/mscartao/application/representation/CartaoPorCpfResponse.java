package com.kowalskiig.mscartao.application.representation;

import com.kowalskiig.mscartao.domain.ClienteCartao;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoPorCpfResponse {
    private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;

    public static CartaoPorCpfResponse fromModel(ClienteCartao clienteCartao){
        var dto = new CartaoPorCpfResponse();

        dto.setNome(clienteCartao.getNome());
        dto.setBandeira(clienteCartao.getCartao().getBandeiraCartao().toString());
        dto.setLimiteLiberado(clienteCartao.getLimite());

        return dto;
    }

}
