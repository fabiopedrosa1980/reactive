package br.com.pedrosa.arquitetura.reactive.handlers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import br.com.pedrosa.arquitetura.reactive.domain.Operacao;
import br.com.pedrosa.arquitetura.reactive.repository.OperacaoRepository;
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

	public Mono<ServerResponse> save(ServerRequest req) {
		Mono<Operacao> operacao = req.bodyToMono(Operacao.class).flatMap(o -> operacaoRepository.save(o));
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(operacao, Operacao.class);

	}

	public Mono<ServerResponse> update(ServerRequest req) {
		Mono<Operacao> operacaoMono = operacaoRepository.findById(req.pathVariable("id")).flatMap(o -> {
			Operacao operIn = req.bodyToMono(Operacao.class).block();
			o.setNome(operIn.getNome());
			return operacaoRepository.save(o);
		});
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(operacaoMono, Operacao.class);

	}

	public Mono<ServerResponse> get(ServerRequest req) {
		return this.operacaoRepository.findById(req.pathVariable("id"))
				.flatMap(operacao -> ServerResponse.ok().body(Mono.just(operacao), Operacao.class))
				.switchIfEmpty(ServerResponse.notFound().build());
	}

	public Mono<ServerResponse> delete(ServerRequest req) {
		return ServerResponse.noContent().build(this.operacaoRepository.deleteById(req.pathVariable("id")));
	}
}
