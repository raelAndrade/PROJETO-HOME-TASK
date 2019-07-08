package br.inpe.embrace.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.inpe.embrace.resources.entities.Imagem;

/**
 * 
 * @author Israel Andrade
 * 
 * Data de criação 7 de jul de 2019
 */

@Service
public interface ImagemService {

	List<Imagem> listar();
	
	Optional<Imagem> buscar(Long id);
	
	Imagem salvar(Imagem imagem);
	
	void deletar(Long id);
	
	void atualizar(Imagem imagem);
}
