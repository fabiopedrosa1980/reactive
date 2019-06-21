package br.com.pedrosa.arquitetura.reactive.handlers;

import br.com.pedrosa.arquitetura.reactive.domain.Operation;
import br.com.pedrosa.arquitetura.reactive.repository.OperationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Log4j2
@Component
public class OperationHandler {

    private final OperationRepository operationRepository;

    public Mono<ServerResponse> all(ServerRequest req) {
        return ServerResponse.ok().body(this.operationRepository.findAll(), Operation.class);
    }

    public Mono<ServerResponse> save(ServerRequest req) {
        log.info("save operation");
        Mono<Operation> operation = req.bodyToMono(Operation.class)
                .flatMap(this.operationRepository::save);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(operation, Operation.class);
    }

    public Mono<ServerResponse> update(ServerRequest req) {
        log.info("update operation");
        return this.operationRepository.findById(req.pathVariable("id"))
                .map(o -> {
                    Operation operation = req.bodyToMono(Operation.class).block();
                    o.setName(operation.getName());
                    return o;
                })
                .flatMap(operation -> ServerResponse.ok().body(this.operationRepository.save(operation), Operation.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> get(ServerRequest req) {
        log.info("get operation");
        return this.operationRepository.findById(req.pathVariable("id"))
                .flatMap(operation -> ServerResponse.ok().body(Mono.just(operation), Operation.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> delete(ServerRequest req) {
        log.info("delete operation");
        return this.operationRepository.findById(req.pathVariable("id"))
                .flatMap(operation -> ServerResponse.noContent().build(this.operationRepository.delete(operation)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
