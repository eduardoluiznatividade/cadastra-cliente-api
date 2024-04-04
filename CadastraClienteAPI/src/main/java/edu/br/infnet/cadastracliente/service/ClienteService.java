package edu.br.infnet.cadastracliente.service;

import java.util.List;
import java.util.Optional;

import edu.br.infnet.cadastracliente.model.Cliente;

public interface ClienteService {
	
	public Cliente salvar (Cliente cliente) ;
	
	public Cliente atualizar(Cliente cliente)throws Exception ;
	
	public Optional<List<Cliente>> listarTodos();

	public Optional<Cliente> pesquisarPorId(Long id);

}
