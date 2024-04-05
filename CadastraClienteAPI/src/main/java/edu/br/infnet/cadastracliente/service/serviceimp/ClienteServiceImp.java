package edu.br.infnet.cadastracliente.service.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.infnet.cadastracliente.model.Cliente;
import edu.br.infnet.cadastracliente.repository.ClienteRepository;
import edu.br.infnet.cadastracliente.service.ClienteService;
import lombok.extern.java.Log;

@Service
@Log
public class ClienteServiceImp implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Cliente salvar(Cliente cliente){
		/*if(cliente.getId()==null) {
			throw new Exception("O cliente não pode ser salvo na base");
		}
		*/
		Cliente clienteSalvo = clienteRepository.save(cliente);
		return clienteSalvo;
	}
	
	@Override
	public Cliente atualizar(Cliente cliente) throws Exception {
		if(cliente.getId()==null) {
			throw new Exception("O cliente não pode ser salvo na base");
		}
		Cliente clienteAtualizado = clienteRepository.save(cliente);
		return clienteAtualizado;
	}

	@Override
	public Optional<List<Cliente>> listarTodos() {
		List<Cliente> resultados = clienteRepository.findAll();
		return resultados.isEmpty()
				? Optional.empty()
						: Optional.of(resultados);
	}

	@Override
	public Optional<Cliente> pesquisarPorId(Long id) {
		return clienteRepository.findById(id);
		
	}


	
}

