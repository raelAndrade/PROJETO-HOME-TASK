package br.inpe.embrace.resources.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.inpe.embrace.domain.service.ImagemService;
import br.inpe.embrace.resources.entities.Imagem;
import br.inpe.embrace.resources.repositories.ImagemRepository;
import br.inpe.embrace.resources.service.impl.exceptions.ImagemNaoEncontradoException;

@Service
public class ImageServiceImpl implements ImagemService {

	@Autowired
	private ImagemRepository imagemRepository;
	
	public List<Imagem> listar() {
		return imagemRepository.findAll();
	}

	public Optional<Imagem> buscar(Long id) {
		Optional<Imagem> imagem = imagemRepository.findById(id);
		if(!imagem.isPresent()) {throw new ImagemNaoEncontradoException("A imagem não pode ser encontrada");}
		return imagem;
	}

	public Imagem salvar(Imagem imagem) {
		return imagemRepository.save(imagem);
	}

	public void deletar(Long id) {
		try {
			imagemRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ImagemNaoEncontradoException("A imagem não pode ser deletado");
		}
	}

	public void atualizar(Imagem imagem) {
		imagemRepository.save(imagem);
	}
}
