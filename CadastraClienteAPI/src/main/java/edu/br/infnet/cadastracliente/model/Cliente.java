package edu.br.infnet.cadastracliente.model;

import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Cliente {
	
	@Getter
	private Long id;
	
	@Getter
	@Setter
	private String nome;
	
	@Getter
	List<Endereco> enderecos;
	
	
	
	public Cliente(String nome) {
		this.nome = nome;
	}
	
	//TODO LIMITAR A 2 ENDERECOS
	public void adicionaEndereco(Endereco endereco) {
		if (enderecos.isEmpty()) {
			enderecos = new ArrayList<Endereco>();
			
			enderecos.add(endereco);
			
		}
	}
	

}
