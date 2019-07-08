package br.inpe.embrace.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.inpe.embrace.resources.entities.Produto;

/**
 * 
 * @author Israel Andrade
 * 
 * Data de criação 7 de jul de 2019
 */

@Service
public interface ProdutoService {
	
	List<Produto> listar();
	
	Optional<Produto> buscar(Long id);
	
	Produto salvar(Produto produto);
	
	void deletar(Long id);
	
	void atualizar(Produto produto);
}
