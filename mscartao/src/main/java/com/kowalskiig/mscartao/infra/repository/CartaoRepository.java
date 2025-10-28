package com.kowalskiig.mscartao.infra.repository;

import com.kowalskiig.mscartao.domain.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {

    List<Cartao> findByrendaLessThanEqual(BigDecimal renda);
}
