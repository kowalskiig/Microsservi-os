package com.kowalskiig.mscartao.application;

import com.kowalskiig.mscartao.application.representation.CartaoSaveRequest;
import com.kowalskiig.mscartao.domain.Cartao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cartoes")
@RequiredArgsConstructor
public class CartoesResource {

    private final CartaoService cartaoService;

    @GetMapping
    public String status(){
        return "ok";
    }

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
}
