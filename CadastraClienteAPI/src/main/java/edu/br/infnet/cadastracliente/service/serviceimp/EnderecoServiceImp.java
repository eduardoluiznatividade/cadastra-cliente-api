package edu.br.infnet.cadastracliente.service.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.infnet.cadastracliente.model.Endereco;
import edu.br.infnet.cadastracliente.repository.EnderecoRepository;
import edu.br.infnet.cadastracliente.service.EnderecoService;
import lombok.extern.java.Log;

@Service
@Log
public class EnderecoServiceImp implements EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
		
	@Override
	public Optional<List<Endereco>> listarTodos() {
		List<Endereco> enderecos = enderecoRepository.findAll();
		
		enderecos.forEach(e -> log.info(e.toString()));
		
		return enderecos.isEmpty()
				? Optional.empty()
						: Optional.of(enderecos);
	}

}
