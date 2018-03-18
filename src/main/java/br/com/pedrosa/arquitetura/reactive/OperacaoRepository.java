package br.com.pedrosa.arquitetura.reactive;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;

public interface OperacaoRepository extends ReactiveSortingRepository<Operacao, String> {
	
	
	
}
