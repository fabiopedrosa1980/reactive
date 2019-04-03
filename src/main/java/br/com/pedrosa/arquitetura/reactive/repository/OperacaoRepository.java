package br.com.pedrosa.arquitetura.reactive.repository;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;

import br.com.pedrosa.arquitetura.reactive.domain.Operacao;

public interface OperacaoRepository extends ReactiveSortingRepository<Operacao, String> {
}
