package com.io.kowalskiig.mscredito.model;

import lombok.Data;

@Data
public class SituacaoCliente {

    private DadosCliente cliente;
    private List<CartaoCliente> cartoes;
}
