package com.io.kowalskiig.mscredito.application;

import com.io.kowalskiig.mscredito.infra.clients.CartoesResourceClient;
import com.io.kowalskiig.mscredito.infra.clients.ClienteResourceClient;
import com.io.kowalskiig.mscredito.model.CartaoCliente;
import com.io.kowalskiig.mscredito.model.DadosCliente;
import com.io.kowalskiig.mscredito.model.SituacaoCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    private final ClienteResourceClient clienteResourceClient;
    private final CartoesResourceClient cartoesResourceClient;

    public SituacaoCliente obterSituacaoCliente(String cpf){

        //obterDadosCliente -MSCLIENTES
        //obter cartoes do cliente
        //requisições para outros microsserviços agora.
        //puxa os dados que você quer no objeto apenas


    ResponseEntity<DadosCliente> dadosClienteResponse = clienteResourceClient.dadosCliente(cpf);
    ResponseEntity<List<CartaoCliente>> cartoesResponse = cartoesResourceClient.listCartoesByCpf(cpf);

    return SituacaoCliente.builder()
            .cliente(dadosClienteResponse.getBody())
            .cartoes(cartoesResponse.getBody())
            .build();


    }
}
