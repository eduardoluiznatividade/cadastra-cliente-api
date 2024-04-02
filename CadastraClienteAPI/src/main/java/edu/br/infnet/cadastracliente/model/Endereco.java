package edu.br.infnet.cadastracliente.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Endereco {
	
	@Getter
	private int id;
	
	@Getter
	@Setter
	private TipoLogradouro tipoLogradouro;
	
	@Getter
	@Setter
	private String nomeLogradouro;
	
	@Getter
	@Setter
	private String numero;
	
	@Getter
	@Setter
	private String Bairro;
	
	@Getter
	@Setter
	private String Cep;
	
	@Getter
	@Setter
	private String complemento;
	
	@Getter
	@Setter
	private TipoEndereco tipoEndereco;

}
