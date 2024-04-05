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
import edu.br.infnet.cadastracliente.model.Endereco;
import edu.br.infnet.cadastracliente.model.TipoLogradouro;
import edu.br.infnet.cadastracliente.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping(value = "/cadastraendereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Operation(summary = "Listar",description = "Lista todos os Endereços", tags="Endereço")
	@GetMapping("/listartodos")
	public Optional<List<Endereco>> listarEnderecos(){
		return enderecoService.listarTodos();
	}
	
	@Operation(summary = "Salvar",description = "Salva um Endereço", tags="Endereço")
	@PostMapping("/salvar")
	public ResponseEntity<Endereco>salvarEndereco(@RequestBody Endereco endereco) {		
			
		Optional<Endereco> optEnderecoFound;
		if(endereco.getId() != 0) {
			optEnderecoFound = enderecoService.mostraTipoEnderecoPorId(endereco.getId());	
			if(!optEnderecoFound.isPresent()){
				enderecoService.salvar(endereco);
				return ResponseEntity.ok(endereco);
			}
		}
		
				 
		return new ResponseEntity<Endereco>(HttpStatus.NOT_ACCEPTABLE);
		
		
	
	}
	
	
	@Operation(summary = "Lista por ID",description = "Lista um enderço utilizando o ID como referencia", tags="Endereço")
	@GetMapping("/lista/{id}")
	public ResponseEntity<Endereco> listaEndereco(@PathVariable("id") int id) {
		Optional<Endereco> opEndereco = enderecoService.mostraTipoEnderecoPorId(id);
		
		if(opEndereco.isPresent()) {
			Endereco enderecoFound = opEndereco.get();		
			return ResponseEntity.ok(enderecoFound);
		}			
		return new ResponseEntity<Endereco>(HttpStatus.NOT_ACCEPTABLE);	
	}
	
	
}
