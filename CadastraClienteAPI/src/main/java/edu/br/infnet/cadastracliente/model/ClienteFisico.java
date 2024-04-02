package edu.br.infnet.cadastracliente.model;


import lombok.Getter;

public class ClienteFisico extends Cliente{
	
	@Getter
	private String numeroCpf;
	
	public ClienteFisico(String nome, String numeroCnpj) {
		super(nome);
		this.numeroCpf = numeroCnpj;
	}

}
