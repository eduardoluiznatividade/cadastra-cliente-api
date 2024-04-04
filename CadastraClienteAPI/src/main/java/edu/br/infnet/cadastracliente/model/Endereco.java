package edu.br.infnet.cadastracliente.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Entity(name = "T_ENDERECO")
@NoArgsConstructor
@AllArgsConstructor
public class Endereco implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Getter
	@Id
	@Column(name = "ID_ENDERECO")
	private int id;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="ID_LOGRADOURO")
	@JsonBackReference(value="endereco-tipoLogradouro")
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
	@Enumerated(EnumType.STRING)
	private TipoEndereco tipoEndereco;
	
	@Getter
	@Setter
	@OneToOne(mappedBy = "enderecos")
	@JoinColumn(name = "cliente_id")
	@JsonBackReference(value="endereco-cliente")
	private Cliente cliente;

}
