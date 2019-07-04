package br.inpe.embrace.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.inpe.embrace.domain.Produto;

@Service
public interface ProdutoService {
	
	List<Produto> listar();
	
	Produto buscar(Long id);
	
	Produto salvar(Produto produto);
	
	void deletar(Long id);
	
	void atualizar(Produto produto);
	
	void verificaSeExiste(Produto produto);
}
