package edu.br.infnet.cadastracliente.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.infnet.cadastracliente.model.Cliente;
import edu.br.infnet.cadastracliente.model.Endereco;
import edu.br.infnet.cadastracliente.model.TipoLogradouro;
import edu.br.infnet.cadastracliente.service.ClienteService;
import edu.br.infnet.cadastracliente.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/cadastracliente")	
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EnderecoService enderecoService;
	
	//TODO Verificar relação OneToOne(se salvarmos 2 endereços em um cliente ele crasha)
	@Operation(summary = "Salvar",description = "Salva um Cliente", tags="Cliente")
	@PostMapping("/salvar")
	public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente) {
		boolean clienteValido = (cliente != null);
		if (!clienteValido) {
			return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
		}
		
		boolean clienteCadastrado = clienteService.pesquisarPorId(cliente.getId()).isPresent();
		if (clienteCadastrado) {
			return new ResponseEntity<Cliente>(HttpStatus.CONFLICT);
		}
		
		boolean clienteEnderecoCasdastrado = enderecoService.pesquisaEnderecoPorId(
				cliente.getEnderecos().getId()).isPresent();
		if (clienteEnderecoCasdastrado) {
			return new ResponseEntity<Cliente>(HttpStatus.CONFLICT);
		}
		
		clienteService.salvar(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	
	@Operation(summary = "Listar",description = "Lista todos os Clientes", tags="Cliente")
	@GetMapping("/listartodos")
	public Optional<List<Cliente>> listarClientes(){
		System.out.println("teste");
		return clienteService.listarTodos();
	}
	
	@Operation(summary = "Procurar por ID",description = "Procura um Cliente utilizando o ID como referencia", tags="Cliente")
	@GetMapping("/lista/{id}")
	public ResponseEntity<Cliente> pesquisarPorId(@PathVariable ("id") Long id){
		
		Optional<Cliente> opCliente = clienteService.pesquisarPorId(id);
		if(opCliente.isPresent()) {
			Cliente clienteFound = opCliente.get();		
			return ResponseEntity.ok(clienteFound);
		}
			
		return ResponseEntity.notFound().build();
	}
}
