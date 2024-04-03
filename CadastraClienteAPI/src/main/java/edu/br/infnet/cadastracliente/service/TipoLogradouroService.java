package edu.br.infnet.cadastracliente.service;

import java.util.Optional;

import edu.br.infnet.cadastracliente.model.TipoLogradouro;

public interface TipoLogradouroService {
	
	public Optional<TipoLogradouro> mostraTipoLogradouroPorId(int id);
	public void deletaTipoLogradouroPorId(int id);
	public void criaTipoLogradouro(TipoLogradouro tipoLogradouro);
	void alteraTipoLogradouro(TipoLogradouro tipoLogradouro);

}
