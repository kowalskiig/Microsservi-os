package com.cliente.microsevices.application;

import com.cliente.microsevices.application.representation.ClienteSaveRequest;
import com.cliente.microsevices.domain.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClientesResource {

    private final ClienteService clienteService;

    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity save (@RequestBody ClienteSaveRequest request){

        var cliente = request.toModel();
        clienteService.save(cliente);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(cliente.getCpf())
                .toUri();

        return ResponseEntity.created(uri).build();

    }

    @GetMapping
    public ResponseEntity dadosCliente(@RequestParam("cpf") String cpf){
        var cliente = clienteService.getByCPF(cpf);

        return ResponseEntity.ok(cliente);
    }



}
