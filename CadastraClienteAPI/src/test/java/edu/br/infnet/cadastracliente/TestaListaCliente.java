package edu.br.infnet.cadastracliente;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.br.infnet.cadastracliente.controller.EnderecoController;
import edu.br.infnet.cadastracliente.model.Endereco;

@SpringBootTest
class TestaListaCliente {
	
	@Autowired
	private EnderecoController enderecoController;

	@Test
	void test() {
		Endereco enderecoEsperado = new Endereco();
		enderecoEsperado.setNomeLogradouro("AV SERNAMBETIBA");
			
		Endereco enderecoAtual = enderecoController.listarEnderecos().get().get(0);
		
		assertEquals(enderecoEsperado.getNomeLogradouro(), enderecoAtual.getNomeLogradouro());

	}

}
