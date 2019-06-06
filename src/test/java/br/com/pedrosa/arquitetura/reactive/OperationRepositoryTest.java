package br.com.pedrosa.arquitetura.reactive;

import br.com.pedrosa.arquitetura.reactive.domain.Operation;
import br.com.pedrosa.arquitetura.reactive.repository.OperationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@DataMongoTest
public class OperationRepositoryTest {

    @Autowired
    private OperationRepository operationRepository;

    @Test
    public void query() {
        Flux<Operation> operationFlux = this.operationRepository.deleteAll()
                .thenMany(
                    Flux.just("A", "A", "C", "E")
                        .map(op -> new Operation(null, op))
                        .flatMap(o -> this.operationRepository.save(o))
                )
                .thenMany(this.operationRepository.findByName("A"));

        StepVerifier
                .create(operationFlux)
                .expectNextCount(2)
                .verifyComplete();

    }


}
