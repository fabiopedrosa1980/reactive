package br.com.pedrosa.arquitetura.reactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OperacaoService {
	
	private OperacaoRepository operacaoRepository;
	
	@Autowired
	public OperacaoService(OperacaoRepository operacaoRepository){
		this.operacaoRepository = operacaoRepository;
	}
	
	
	public Mono<Operacao> findById(String id){
		return operacaoRepository.findById(id);
	}
	
	public Flux<Operacao> getAllOperacao(){
		return operacaoRepository.findAll();
	}
	
	public void save(Operacao operacao) {
		operacaoRepository.save(operacao);
	}
	
	public void update(Operacao operacao) {
		operacaoRepository.save(operacao);
	}
	
	public void delete(String id) {
		operacaoRepository.deleteById(id);
	}
	
	
}
