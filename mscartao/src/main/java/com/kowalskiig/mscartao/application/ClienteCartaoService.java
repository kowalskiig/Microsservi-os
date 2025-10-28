package com.kowalskiig.mscartao.application;

import com.kowalskiig.mscartao.domain.ClienteCartao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {

    private final ClienteCartaoService repository;

    public List<ClienteCartao> listCartoesByCpf(String cpf){
        return repository.listCartoesByCpf(cpf);

    }


}
