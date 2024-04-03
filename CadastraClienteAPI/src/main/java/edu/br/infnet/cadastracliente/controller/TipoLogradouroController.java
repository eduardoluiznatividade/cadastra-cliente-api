package edu.br.infnet.cadastracliente.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.infnet.cadastracliente.model.TipoLogradouro;
import edu.br.infnet.cadastracliente.service.TipoLogradouroService;

@RestController
@RequestMapping("/LogradouroController")
public class TipoLogradouroController {
	
	@Autowired
	TipoLogradouroService tipoLogradouroService;
	

	@GetMapping("/LogradouroController/{id}")
	public TipoLogradouro listaLogradouro(@PathVariable("id") int id) {
		
		Optional<TipoLogradouro> opTipoLogradouro = tipoLogradouroService.mostraTipoLogradouroPorId(id);
		
		if(opTipoLogradouro.isPresent()) {
			TipoLogradouro TipoLogradouroFound = opTipoLogradouro.get();		
			return TipoLogradouroFound;
		}
			
		return null;
	}
	
	@PostMapping("/LogradouroController")
	public void insereLogradouro(TipoLogradouro tipoLogradouro) {
		tipoLogradouroService.criaTipoLogradouro(tipoLogradouro);
	}
	
	@DeleteMapping("/LogradouroController/{id}")
	public void deletaLogradouro(@PathVariable("id") int id) {
		tipoLogradouroService.deletaTipoLogradouroPorId(id);
	}
	
	@PutMapping("/LogradouroController/{id}")
	public void alteraLogradouro(@PathVariable("id") int id,@RequestBody TipoLogradouro tipoLogradouro) {
		tipoLogradouroService.alteraTipoLogradouro(tipoLogradouro);
	}	
	
	
}
