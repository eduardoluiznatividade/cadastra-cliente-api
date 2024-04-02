package edu.br.infnet.cadastracliente.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.br.infnet.cadastracliente.model.Endereco;
import edu.br.infnet.cadastracliente.service.EnderecoService;


@RestController
@RequestMapping(value = "/cadastracliente")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
		
	@PostMapping("/listartodos")
	public Optional<List<Endereco>> listarEnderecos(){
		return enderecoService.listarTodos();
	}

}
