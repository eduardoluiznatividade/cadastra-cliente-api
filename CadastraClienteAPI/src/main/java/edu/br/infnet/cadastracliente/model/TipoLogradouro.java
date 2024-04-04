package edu.br.infnet.cadastracliente.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Entity(name = "T_TIPO_LOGRADOURO")	
public class TipoLogradouro implements Serializable{

	private static final long serialVersionUID = 1L;

	@Getter
	@Id
	@Column(name = "ID_LOGRADOURO")
	private int id;
	
	@Getter
	@Setter
	@Column(name = "SG_ABREVIACAO")
	private String abreviacao;
	
	@Getter
	@Setter
	@Column(name = "DS_ENDERECO")
	private String descricao;
	
	@Getter
	@OneToMany (mappedBy = "tipoLogradouro" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JsonManagedReference(value="endereco-tipoLogradouro")
	private List<Endereco> enderecos;
	
	
	public TipoLogradouro(String abreviacao, String descricao) {
		this.abreviacao = abreviacao;
		this.descricao = descricao;
	}
	

}
