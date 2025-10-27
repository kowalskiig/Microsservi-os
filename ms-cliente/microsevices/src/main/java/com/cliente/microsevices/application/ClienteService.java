package com.cliente.microsevices.application;

import com.cliente.microsevices.domain.Cliente;
import com.cliente.microsevices.infra.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Transactional
    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> getByCPF(String Cpf){
        return clienteRepository.findByCpf(Cpf);
    }
}
