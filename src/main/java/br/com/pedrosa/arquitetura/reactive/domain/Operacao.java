package br.com.pedrosa.arquitetura.reactive.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "operacoes")
public class Operacao {
	
	private String id;
	
	private String nome;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
