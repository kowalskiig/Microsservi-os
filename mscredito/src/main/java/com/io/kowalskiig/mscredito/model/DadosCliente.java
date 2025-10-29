package com.io.kowalskiig.mscredito.model;

import lombok.Data;

@Data
public class DadosCliente {

    private Long id;
    private String cpf;
    private String nome;
    private Integer idade;
}
