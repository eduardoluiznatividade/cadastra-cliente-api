package edu.br.infnet.cadastracliente.service;

import java.util.List;
import java.util.Optional;

import edu.br.infnet.cadastracliente.model.Cliente;
import edu.br.infnet.cadastracliente.model.Endereco;
import edu.br.infnet.cadastracliente.model.TipoLogradouro;

public interface EnderecoService {
	
	public Optional<List<Endereco>> listarTodos();
	
	public Endereco salvar (Endereco endereco) ;
	
	public Optional<Endereco> pesquisaEnderecoPorId(int id);}
