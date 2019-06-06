package br.com.pedrosa.arquitetura.reactive.repository;

import br.com.pedrosa.arquitetura.reactive.domain.Operation;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

public interface OperationRepository extends ReactiveSortingRepository<Operation, String> {

    Flux<Operation> findByName(String name);
}
