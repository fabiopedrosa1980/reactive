package br.com.pedrosa.arquitetura.reactive.handlers;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Log4j2
@Component
public class OperationHandler {

    /*private final OperationRepository operationRepository;

    public Mono<ServerResponse> all(ServerRequest req) {
        return ServerResponse.ok().body(this.operationRepository.findAll(), Operation.class);
    }

    public Mono<ServerResponse> save(ServerRequest req) {
        log.info("save operation");
        Mono<Operation> operation = req.bodyToMono(Operation.class)
            .flatMap(o -> operationRepository.save(o));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(operation, Operation.class);
    }

    public Mono<ServerResponse> update(ServerRequest req) {
        log.info("update operation 2");
        Mono<Operation> operationMono = operationRepository.findById(req.pathVariable("id"))
            .map(o -> {
                Operation operation = req.bodyToMono(Operation.class).block();
                o.setName(operation.getName());
                return  o;
            })
            .flatMap(o -> operationRepository.save(o));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(operationMono, Operation.class);
    }

    public Mono<ServerResponse> get(ServerRequest req) {
        return this.operationRepository.findById(req.pathVariable("id"))
            .flatMap(operation -> ServerResponse.ok().body(Mono.just(operation), Operation.class))
            .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> delete(ServerRequest req) {
        return ServerResponse.noContent().build(this.operationRepository.deleteById(req.pathVariable("id")));
    }*/
}
