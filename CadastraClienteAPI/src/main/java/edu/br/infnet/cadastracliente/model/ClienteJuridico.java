package edu.br.infnet.cadastracliente.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.ToString;


@ToString
public class ClienteJuridico extends Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	@Getter
	private String numeroCnpj;
	
	
	
	public ClienteJuridico(String nome, String numeroCnpj) {
		super(nome);
		this.numeroCnpj = numeroCnpj;
	}

}
