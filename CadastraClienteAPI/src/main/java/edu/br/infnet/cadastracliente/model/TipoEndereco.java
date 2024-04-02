package edu.br.infnet.cadastracliente.model;

public enum TipoEndereco {
	
	RESIDENCIAL ("Residencial"),
	COMERCIAL ("Comercial"),
	OUTROS ("Outros");
	
	private String descricao;
	
	private TipoEndereco(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

}
