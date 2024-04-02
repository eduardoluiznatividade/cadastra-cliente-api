package edu.br.infnet.cadastracliente.service;

import java.util.List;
import java.util.Optional;

import edu.br.infnet.cadastracliente.model.Endereco;

public interface EnderecoService {
	
	public Optional<List<Endereco>> listarTodos();
	

}
