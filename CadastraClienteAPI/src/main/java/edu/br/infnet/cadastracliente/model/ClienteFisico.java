package edu.br.infnet.cadastracliente.model;


import java.io.Serializable;

import lombok.Getter;

public class ClienteFisico extends Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	@Getter
	private String numeroCpf;
	
	public ClienteFisico(String nome, String numeroCnpj) {
		super(nome);
		this.numeroCpf = numeroCnpj;
	}

}
