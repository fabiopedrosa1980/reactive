package br.com.pedrosa.arquitetura.reactive.controller;

import br.com.pedrosa.arquitetura.reactive.domain.Operation;
import br.com.pedrosa.arquitetura.reactive.exception.ResourceNotFoundException;
import br.com.pedrosa.arquitetura.reactive.repository.OperationRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@RestController
//@RequestMapping("operation")
@AllArgsConstructor
public class OperationController {

    /*private OperationRepository operationRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Operation> listAll() {
        return this.operationRepository.findAll();
    }

    @GetMapping("{id}")
    public Mono<Operation> findById(@PathVariable("id") String id) {
        return this.operationRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Operation not found")));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Operation> save(@RequestBody Operation operation) {
        return this.operationRepository.save(operation);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Operation> update(@PathVariable("id") String id, @RequestBody Operation operation) {
        return this.operationRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Operation not found")))
                .map(o -> {
                    o.setName(operation.getName());
                    return o;
                })
                .flatMap(this.operationRepository::save);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        this.operationRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Operation not found")))
                .flatMap(this.operationRepository::delete);
    }*/


}
