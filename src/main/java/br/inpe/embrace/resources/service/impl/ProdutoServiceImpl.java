package br.inpe.embrace.resources.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.inpe.embrace.domain.service.ProdutoService;
import br.inpe.embrace.resources.entities.Produto;
import br.inpe.embrace.resources.repositories.ProdutoRepository;
import br.inpe.embrace.resources.service.impl.exceptions.ProdutoNaoEncontradoException;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> listar(){
		return produtoRepository.findAll();
	}
	
	public Optional<Produto> buscar(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if(produto == null) {throw new ProdutoNaoEncontradoException("O produto não pode ser encontrado");}
		return produto;
	}
	
	public Produto salvar(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public void deletar(Long id) {
		try {
			produtoRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ProdutoNaoEncontradoException("O produto não pode ser deletado");
		}
	}
	
	public void atualizar(Produto produto) {
		produtoRepository.save(produto);
	}
}
