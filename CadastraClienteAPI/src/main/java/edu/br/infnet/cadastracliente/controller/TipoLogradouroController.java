package edu.br.infnet.cadastracliente.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public void insereLogradouro(@RequestBody TipoLogradouro tipoLogradouro) {
		tipoLogradouroService.criaTipoLogradouro(tipoLogradouro);
	}
	
	@Operation(summary = "Deletar ",description = "Deleta um tipo de logradouro utilizando o ID como referencia", tags="TipoLogradouro")
	@DeleteMapping("/deleta/{id}")
	public void deletaLogradouro(@PathVariable("id") int id) {
		tipoLogradouroService.deletaTipoLogradouroPorId(id);
	}
	
	@Operation(summary = "Alterar",description = "Altera um tipo de logradouro utilizando o ID como referencia", tags="TipoLogradouro")
	@PutMapping("/altera/{id}")
	public void alteraLogradouro(@PathVariable("id") int id,@RequestBody TipoLogradouro tipoLogradouro) {
		tipoLogradouroService.alteraTipoLogradouro(tipoLogradouro);
	}	
	
	
}
