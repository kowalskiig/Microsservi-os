package com.kowalskiig.mscartao.application;

import com.kowalskiig.mscartao.application.representation.CartaoPorCpfResponse;
import com.kowalskiig.mscartao.application.representation.CartaoSaveRequest;
import com.kowalskiig.mscartao.domain.Cartao;
import com.kowalskiig.mscartao.domain.ClienteCartao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cartoes")
@RequiredArgsConstructor
public class CartoesResource {

    private final CartaoService cartaoService;
    private final ClienteCartaoService clienteCartaoService;

    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CartaoSaveRequest request){
        var cartao = request.toModel();
        cartaoService.save(cartao);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(cartao.getId())
                .toUri();

        return ResponseEntity.created(uri).build();


    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartaoPorCpfResponse>> listCartoesByCpf(
            @RequestParam("cpf") String cpf){
        List<ClienteCartao> cartoes = clienteCartaoService.listCartoesByCpf(cpf);

        List<CartaoPorCpfResponse> result = cartoes.stream().map(CartaoPorCpfResponse::fromModel).toList();

        return ResponseEntity.ok(result);
    }
}
