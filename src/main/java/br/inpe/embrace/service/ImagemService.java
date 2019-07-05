package br.inpe.embrace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.inpe.embrace.domain.Imagem;

@Service
public interface ImagemService {

	List<Imagem> listar();
	
	Optional<Imagem> buscar(Long id);
	
	Imagem salvar(Imagem imagem);
	
	void deletar(Long id);
	
	void atualizar(Imagem imagem);
	
	void verificaSeExiste(Imagem imagem);
}
