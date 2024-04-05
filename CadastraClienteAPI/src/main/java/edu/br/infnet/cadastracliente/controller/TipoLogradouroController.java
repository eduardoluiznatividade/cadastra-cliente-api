package edu.br.infnet.cadastracliente.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/LogradouroController")
public class TipoLogradouroController {
	
	@Autowired
	TipoLogradouroService tipoLogradouroService;
	
	@Operation(summary = "Buscar",description = "Procura por um tipo de logradouro usando ID como referencia", tags="TipoLogradouro")
	@GetMapping("/lista/{id}")
	public ResponseEntity<TipoLogradouro> listaLogradouro(@PathVariable("id") int id) {
		Optional<TipoLogradouro> opTipoLogradouro = tipoLogradouroService.mostraTipoLogradouroPorId(id);
		if(opTipoLogradouro.isPresent()) {
			TipoLogradouro TipoLogradouroFound = opTipoLogradouro.get();		
			return ResponseEntity.ok(TipoLogradouroFound);
		}
			
		return ResponseEntity.notFound().build();
	}
	
	@Operation(summary = "Salvar",description = "Salva um tipo de logradouro", tags="TipoLogradouro")
	@PostMapping("/salvar")
	public ResponseEntity<TipoLogradouro> insereLogradouro(@RequestBody TipoLogradouro tipoLogradouro) {
			
		Optional<TipoLogradouro> optTipoLougradouroFound;
		if(tipoLogradouro.getId() != 0) {
			optTipoLougradouroFound = tipoLogradouroService.mostraTipoLogradouroPorId(tipoLogradouro.getId());	
			if(!optTipoLougradouroFound.isPresent()){
				tipoLogradouroService.criaTipoLogradouro(tipoLogradouro);
				return ResponseEntity.ok(tipoLogradouro);
			}
		}
		
				 
		return new ResponseEntity<TipoLogradouro>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@Operation(summary = "Deletar ",description = "Deleta um tipo de logradouro utilizando o ID como referencia", tags="TipoLogradouro")
	@DeleteMapping("/deleta/{id}")
	public ResponseEntity<Void> deletaLogradouro(@PathVariable("id") int id) {
		
		Optional<TipoLogradouro> opTipoLogradouro = tipoLogradouroService.mostraTipoLogradouroPorId(id);
	
		if(!opTipoLogradouro.isPresent()) {
			
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		tipoLogradouroService.deletaTipoLogradouroPorId(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@Operation(summary = "Alterar",description = "Altera um tipo de logradouro utilizando o ID como referencia", tags="TipoLogradouro")
	@PutMapping("/altera/")
	public ResponseEntity<TipoLogradouro> alteraLogradouro(@RequestBody TipoLogradouro tipoLogradouro) {
		
		
		Optional<TipoLogradouro> optTipoFound = tipoLogradouroService.mostraTipoLogradouroPorId(tipoLogradouro.getId());
		if(!optTipoFound.isPresent()) {
			return new ResponseEntity<TipoLogradouro>(HttpStatus.NOT_FOUND);
		}
		tipoLogradouroService.alteraTipoLogradouro(tipoLogradouro);
		
		return ResponseEntity.ok(tipoLogradouro);
	}	
	
	
}
