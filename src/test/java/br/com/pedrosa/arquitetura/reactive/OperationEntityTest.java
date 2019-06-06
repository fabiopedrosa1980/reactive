package br.com.pedrosa.arquitetura.reactive;

import br.com.pedrosa.arquitetura.reactive.domain.Operation;
import br.com.pedrosa.arquitetura.reactive.routers.OperationRouter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@DataMongoTest
public class OperationEntityTest {

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @Test
    public void persist() throws  Exception{
        Operation operation = new Operation(null,"nova");
        Mono<Operation> save = this.reactiveMongoTemplate.save(operation);

        StepVerifier
            .create(save)
            .expectNextMatches(op -> op.getName().equalsIgnoreCase("nova") && op.getId() != null)
            .verifyComplete();


    }

}
