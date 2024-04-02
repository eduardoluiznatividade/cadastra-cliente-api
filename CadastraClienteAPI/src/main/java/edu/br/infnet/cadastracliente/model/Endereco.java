package edu.br.infnet.cadastracliente.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Entity(name = "T_ENDERECO")
@NoArgsConstructor
public class Endereco implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ENDERECO")
	private int id;
	
	@Getter
	@Setter
	@Column(name = "TP_LOGRADOURO")
	@Transient
	private TipoLogradouro tipoLogradouro;
	
	@Getter
	@Setter
	@Column(name = "NM_LOGRADOURO")
	private String nomeLogradouro;
	
	@Getter
	@Setter
	@Column(name = "NR_LOGRADOURO")
	private String numero;
	
	@Getter
	@Setter
	@Column(name = "DS_BAIRRO")
	private String Bairro;
	
	@Getter
	@Setter
	@Column(name = "NR_CEP")
	private String Cep;
	
	@Getter
	@Setter
	@Column(name = "DS_COMPLEMENTO")
	private String complemento;
	
	@Getter
	@Setter
	@Column(name = "TP_ENDERECO")
	@Transient
	private TipoEndereco tipoEndereco;

}
