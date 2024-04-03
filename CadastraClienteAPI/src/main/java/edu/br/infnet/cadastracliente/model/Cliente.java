package edu.br.infnet.cadastracliente.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity(name = "T_CLIENTE")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CLIENTE")
	private Long id;
	
	@Getter
	@Setter
	@Column(name = "NM_CLIENTE")
	private String nome;
	
	@Getter
	@Transient
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
