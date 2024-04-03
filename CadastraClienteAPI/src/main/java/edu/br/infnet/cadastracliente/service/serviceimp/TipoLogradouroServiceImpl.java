package edu.br.infnet.cadastracliente.service.serviceimp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.infnet.cadastracliente.model.TipoLogradouro;
import edu.br.infnet.cadastracliente.repository.TipoLogradouroRepository;
import edu.br.infnet.cadastracliente.service.TipoLogradouroService;


@Service
public class TipoLogradouroServiceImpl implements TipoLogradouroService{
	
	@Autowired
	TipoLogradouroRepository tipoLogradouroRepository;

	@Override
	public Optional<TipoLogradouro> mostraTipoLogradouroPorId(int id) {
			
		return  tipoLogradouroRepository.findById(id);
	}

	@Override
	public void deletaTipoLogradouroPorId(int id) {
		
		tipoLogradouroRepository.deleteById(id);
	}

	@Override
	public void criaTipoLogradouro(TipoLogradouro tipoLogradouro) {
		
		tipoLogradouroRepository.save(tipoLogradouro);
	}

	@Override
	public void alteraTipoLogradouro(TipoLogradouro tipoLogradouro) {
		
		tipoLogradouroRepository.save(tipoLogradouro);	
	}

}
