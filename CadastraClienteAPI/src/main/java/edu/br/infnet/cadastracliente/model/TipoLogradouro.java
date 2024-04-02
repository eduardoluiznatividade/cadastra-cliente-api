package edu.br.infnet.cadastracliente.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Entity(name = "T_TIPO_ENDERECO")	
public class TipoLogradouro implements Serializable{

	private static final long serialVersionUID = 1L;

	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TIPO_ENDERECO")
	private int id;
	
	@Getter
	@Setter
	@Column(name = "SG_ABREVIACAO")
	private String abreviacao;
	
	@Getter
	@Setter
	@Column(name = "DS_ENDERECO")
	private String descricao;
	
	
	public TipoLogradouro(String abreviacao, String descricao) {
		this.abreviacao = abreviacao;
		this.descricao = descricao;
	}
	

}
