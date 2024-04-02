package edu.br.infnet.cadastracliente.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.infnet.cadastracliente.model.Cliente;
import edu.br.infnet.cadastracliente.model.Endereco;
import edu.br.infnet.cadastracliente.service.ClienteService;
import edu.br.infnet.cadastracliente.service.EnderecoService;

@RestController
@RequestMapping(value = "/cadastracliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
		
	@PostMapping("/listartodos")
	public Optional<List<Cliente>> listarClientes(){
		return clienteService.listarTodos();
	}
}
