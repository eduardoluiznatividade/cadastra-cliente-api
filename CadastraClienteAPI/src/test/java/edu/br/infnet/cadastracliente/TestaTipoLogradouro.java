package edu.br.infnet.cadastracliente;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.br.infnet.cadastracliente.model.TipoLogradouro;
import edu.br.infnet.cadastracliente.service.TipoLogradouroService;

@SpringBootTest
public class TestaTipoLogradouro {
	
	@Autowired
	TipoLogradouroService tipoLogradouroService;

	@Test
	@DisplayName("Testa criar tipo logradouro")
	public void testaCriação() {
		
		TipoLogradouro tipoLogradouroNovo = new TipoLogradouro("Av","Avenida SERNAMBETIBA desc");
		
		Optional<TipoLogradouro> optTipoLogradouro = tipoLogradouroService.mostraTipoLogradouroPorId(1);
		TipoLogradouro TipoLogradouroFound = optTipoLogradouro.get();
		
		assertEquals(TipoLogradouroFound.getDescricao(), tipoLogradouroNovo.getDescricao());
		
	}
	
	@Test
	@DisplayName("Testa deletar tipo logradouro")
	public void testaDelete() {
		
		Optional<TipoLogradouro> optTipoLogradouro = tipoLogradouroService.mostraTipoLogradouroPorId(1);
		TipoLogradouro TipoLogradouroFound = optTipoLogradouro.get();
			
		tipoLogradouroService.deletaTipoLogradouroPorId(1);
		
		optTipoLogradouro = tipoLogradouroService.mostraTipoLogradouroPorId(1);
		
		assertTrue(optTipoLogradouro.isEmpty());
	}
		
	@Test
	@DisplayName("Testa procura tipo logradouro")
	public void testaProcuraPorId() {
		
		Optional<TipoLogradouro> optTipoLogradouro = tipoLogradouroService.mostraTipoLogradouroPorId(1);
		TipoLogradouro TipoLogradouroFound = optTipoLogradouro.get();
		assertEquals("Avenida SERNAMBETIBA desc", TipoLogradouroFound.getDescricao());
		
		
	}
	
	@Test
	@DisplayName("Testa alterar tipo logradouro")
	public void testaAlteraçãoDeLougradouro() {
		
		Optional<TipoLogradouro> optTipoLogradouro = tipoLogradouroService.mostraTipoLogradouroPorId(1);
		TipoLogradouro TipoLogradouroAlteracao = optTipoLogradouro.get();

		
		TipoLogradouroAlteracao.setDescricao("Nova Descrição");	
		tipoLogradouroService.alteraTipoLogradouro(TipoLogradouroAlteracao);
		
		assertEquals("Nova Descrição", TipoLogradouroAlteracao.getDescricao());
		
	}
	
}
