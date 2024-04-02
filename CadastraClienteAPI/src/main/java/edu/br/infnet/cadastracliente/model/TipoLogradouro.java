package edu.br.infnet.cadastracliente.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class TipoLogradouro {
	
	@Getter
	private int id;
	
	@Getter
	@Setter
	private String abreviacao;
	
	@Getter
	@Setter
	private String descricao;
	
	
	public TipoLogradouro(String abreviacao, String descricao) {
		this.abreviacao = abreviacao;
		this.descricao = descricao;
	}
	

}
