package br.com.pedrosa.arquitetura.reactive;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "operacoes")
public class Operacao {
	
	private String id;
	
	private String chaveSistema;
	
	private String dataOperacao;
	
	private String cpfCnpj;
	
	private String token;
	
	private String estabelecimentoComercial;
	
	private String valor;
	
	private String nomeOperacao;
	
	private String cartaoTruncado;
	
	private String tid;
	
	private Object entrada;
	
	private Object retorno;

	public String getChaveSistema() {
		return chaveSistema;
	}

	public void setChaveSistema(String chaveSistema) {
		this.chaveSistema = chaveSistema;
	}

	public String getDataOperacao() {
		return dataOperacao;
	}

	public void setDataOperacao(String dataOperacao) {
		this.dataOperacao = dataOperacao;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEstabelecimentoComercial() {
		return estabelecimentoComercial;
	}

	public void setEstabelecimentoComercial(String estabelecimentoComercial) {
		this.estabelecimentoComercial = estabelecimentoComercial;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getNomeOperacao() {
		return nomeOperacao;
	}

	public void setNomeOperacao(String nomeOperacao) {
		this.nomeOperacao = nomeOperacao;
	}

	public String getCartaoTruncado() {
		return cartaoTruncado;
	}

	public void setCartaoTruncado(String cartaoTruncado) {
		this.cartaoTruncado = cartaoTruncado;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public Object getEntrada() {
		return entrada;
	}

	public void setEntrada(Object entrada) {
		this.entrada = entrada;
	}

	public Object getRetorno() {
		return retorno;
	}

	public void setRetorno(Object retorno) {
		this.retorno = retorno;
	}
	
	public boolean isSale() {
		return "autorizarComToken".equals(this.getNomeOperacao()) || "autorizarSemToken".equals(this.getNomeOperacao());
	}
	
	public boolean isCancel() {
		return "cancelarVenda".equals(this.getNomeOperacao());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
