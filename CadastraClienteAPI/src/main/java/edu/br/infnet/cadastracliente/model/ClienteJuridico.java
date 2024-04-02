package edu.br.infnet.cadastracliente.model;

import lombok.Getter;
import lombok.ToString;


@ToString
public class ClienteJuridico extends Cliente {
	
	@Getter
	private String numeroCnpj;
	
	
	
	public ClienteJuridico(String nome, String numeroCnpj) {
		super(nome);
		this.numeroCnpj = numeroCnpj;
	}

}
