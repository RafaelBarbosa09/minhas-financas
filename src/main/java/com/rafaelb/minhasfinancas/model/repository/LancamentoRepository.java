package com.rafaelb.minhasfinancas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaelb.minhasfinancas.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
