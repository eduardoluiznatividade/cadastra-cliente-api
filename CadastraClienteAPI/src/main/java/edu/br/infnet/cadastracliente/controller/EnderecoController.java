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
import edu.br.infnet.cadastracliente.model.Endereco;
import edu.br.infnet.cadastracliente.model.TipoLogradouro;
import edu.br.infnet.cadastracliente.service.EnderecoService;


@RestController
@RequestMapping(value = "/cadastraendereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
		
	@GetMapping("/listartodos")
	public Optional<List<Endereco>> listarEnderecos(){
		return enderecoService.listarTodos();
	}
	
	@PostMapping("/salvar")
	public Endereco salvarEndereco(@RequestBody Endereco endereco) {		
			return enderecoService.salvar(endereco);
	}
	
	@GetMapping("/lista/{id}")
	public Endereco listaEndereco(@PathVariable("id") int id) {
		Optional<Endereco> opTipoLogradouro = enderecoService.mostraTipoEnderecoPorId(id);
		if(opTipoLogradouro.isPresent()) {
			Endereco TipoLogradouroFound = opTipoLogradouro.get();		
			return TipoLogradouroFound;
		}			
		return null;	
	}
	
	
}
