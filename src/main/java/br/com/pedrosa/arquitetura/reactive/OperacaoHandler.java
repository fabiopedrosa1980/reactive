package br.com.pedrosa.arquitetura.reactive;

import java.net.URI;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class OperacaoHandler {
	private final OperacaoRepository operacaoRepository;

    public OperacaoHandler(OperacaoRepository operacaoRepository) {
        this.operacaoRepository = operacaoRepository;
    }

    public Mono<ServerResponse> all(ServerRequest req) {
        return ServerResponse.ok().body(this.operacaoRepository.findAll(), Operacao.class);
    }

    public Mono<ServerResponse> create(ServerRequest req) {
        return req.bodyToMono(Operacao.class)
            .flatMap(post -> this.operacaoRepository.save(post))
            .flatMap(p -> ServerResponse.created(URI.create("/operacao/" + p.getId())).build());
    }

    public Mono<ServerResponse> get(ServerRequest req) {
        return this.operacaoRepository.findById(req.pathVariable("id"))
            .flatMap(operacao -> ServerResponse.ok().body(Mono.just(operacao), Operacao.class))
            .switchIfEmpty(ServerResponse.notFound().build());
    }

    /*public Mono<ServerResponse> update(ServerRequest req) {

        return Mono
            .zip(
                (data) -> {
                    Operacao p = (Post) data[0];
                    Post p2 = (Post) data[1];
                    p.setTitle(p2.getTitle());
                    p.setContent(p2.getContent());
                    return p;
                },
                this.operacaoRepository.findByEstabelecimentoComercial(req.pathVariable("numeroEstabelecimento")),
                req.bodyToMono(Operacao.class)
            )
            .cast(Post.class)
            .flatMap(post -> this.posts.save(post))
            .flatMap(post -> ServerResponse.noContent().build());

    }*/

    public Mono<ServerResponse> delete(ServerRequest req) {
        return ServerResponse.noContent().build(this.operacaoRepository.deleteById(req.pathVariable("id")));
    }
}
