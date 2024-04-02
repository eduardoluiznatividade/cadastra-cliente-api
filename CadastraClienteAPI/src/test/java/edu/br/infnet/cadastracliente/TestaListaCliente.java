package edu.br.infnet.cadastracliente;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.br.infnet.cadastracliente.controller.ClienteController;
import edu.br.infnet.cadastracliente.controller.EnderecoController;
import edu.br.infnet.cadastracliente.model.Cliente;
import edu.br.infnet.cadastracliente.model.Endereco;

@SpringBootTest
class TestaListaCliente {
	
	@Autowired
	private EnderecoController enderecoController;
	@Autowired
	private ClienteController clienteController;

	@Test
	void test() {
		Endereco enderecoEsperado = new Endereco();
		enderecoEsperado.setNomeLogradouro("AV SERNAMBETIBA");
			
		Endereco enderecoAtual = enderecoController.listarEnderecos().get().get(0);
		
		assertEquals(enderecoEsperado.getNomeLogradouro(), enderecoAtual.getNomeLogradouro());

	}
	@Test
	void testCliente() {
		Cliente clienteEsperado = new Cliente();
		clienteEsperado.setNome("JOSE");
			
		Cliente clienteAtual = clienteController.listarClientes().get().get(0);
		
		assertEquals(clienteEsperado.getNome(), clienteAtual.getNome());
	}

}
