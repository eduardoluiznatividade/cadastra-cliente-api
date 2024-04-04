package edu.br.infnet.cadastracliente.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.infnet.cadastracliente.model.Cliente;
import edu.br.infnet.cadastracliente.model.Endereco;
import edu.br.infnet.cadastracliente.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/cadastracliente")	
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	
	@Operation(summary = "Salvar",description = "Salva um Cliente", tags="Cliente")
	@PostMapping("/salvar")
	public Cliente salvarEndereco(@RequestBody Cliente cliente) {		
			return clienteService.salvar(cliente);
	}
	
	
	@Operation(summary = "Listar",description = "Lista todos os Clientes", tags="Cliente")
	@GetMapping("/listartodos")
	public Optional<List<Cliente>> listarClientes(){
		System.out.println("teste");
		return clienteService.listarTodos();
	}
	
	@Operation(summary = "Procurar por ID",description = "Procura um Cliente utilizando o ID como referencia", tags="Cliente")
	@GetMapping("/lista/{id}")
	public Optional<Cliente> pesquisarPorId(@PathVariable ("id") Long id){
		return clienteService.pesquisarPorId(id);
	}
}
