package edu.br.infnet.cadastracliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.br.infnet.cadastracliente.model.TipoLogradouro;

@Repository
public interface TipoLogradouroRepository extends JpaRepository<TipoLogradouro, Integer>{

}
