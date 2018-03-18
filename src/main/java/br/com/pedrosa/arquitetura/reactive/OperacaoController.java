package br.com.pedrosa.arquitetura.reactive;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperacaoController {
	
	/*private OperacaoService operacaoService;

	@Autowired
	public OperacaoController(OperacaoService operacaoService) {
		this.operacaoService = operacaoService;
	}

	@PostMapping("/operacao")
	Mono<Void> create(@RequestBody Operacao person) {
		return this.repository.save(person).then();
	}

	@GetMapping("/operacao")
	Flux<Operacao> list() {
		return this.operacaoService.getAllOperacao();
	}
	
	@GetMapping("/operacao/{estabelecimento}") 
	Flux<Operacao> find(@PathVariable String estabelecimento,Pageable pageable) {
		return this.operacaoService.findByEstabelecimentoComercial(estabelecimento, pageable);
	}*/

}
