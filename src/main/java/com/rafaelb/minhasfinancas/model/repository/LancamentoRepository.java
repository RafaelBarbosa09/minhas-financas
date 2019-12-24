package com.rafaelb.minhasfinancas.model.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rafaelb.minhasfinancas.model.entity.Lancamento;
import com.rafaelb.minhasfinancas.model.enums.TipoLancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

	@Query(value = "select sum(l.valor) from Lancamento l join l.usuario u "
				 + "where u.id = :idUsuario and l.tipo = :tipo group by u")
	BigDecimal obterSaldoTipoLancamentoEUsuario(@Param("idUsuario") Long idUsuario, @Param("tipo") TipoLancamento tipo);
}
