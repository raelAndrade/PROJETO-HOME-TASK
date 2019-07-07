package br.inpe.embrace.application.resource;

import static br.inpe.embrace.application.resource.util.Constants.API;
import static br.inpe.embrace.application.resource.util.Constants.IMAGENS;
import static br.inpe.embrace.application.resource.util.Constants.V1;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.inpe.embrace.resources.entities.Imagem;
import br.inpe.embrace.resources.service.impl.ImageServiceImpl;
import br.inpe.embrace.resources.service.impl.ProdutoServiceImpl;

@RestController
@RequestMapping(
	API + V1 + IMAGENS
)
public class ImagemResource {
	
	@Autowired
	private ImageServiceImpl imagensService;
	@Autowired
	private ProdutoServiceImpl produtosService;
	
	@GetMapping
	public ResponseEntity<List<Imagem>> exibirImagem() {
		return ResponseEntity.ok().body(imagensService.listar());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Imagem> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok().body(imagensService.buscar(id).get());
	}

	@PostMapping
	public ResponseEntity<Imagem> salvar(@RequestBody @Valid Imagem imagem) throws Exception {
		if(imagem.getProduto() == null) throw new Exception("É obrigatório informar um produto!");
		
		validaSeProdutoExiste(imagem);
		return ResponseEntity.ok().body(imagensService.salvar(imagem));
	}

	@PutMapping
	public ResponseEntity<Imagem> atualizar(@RequestBody @Valid Imagem imagem) throws Exception {
		if(imagem.getId() == null) throw new Exception("É obrigatório informar o id da imagem a ser atualizada!");
		
		final Imagem consulta = imagensService.buscar(imagem.getId()).get();
		
		final Imagem paraAtualizar = Imagem.of(
				consulta.getId(), 
				imagem.getNome() == null ? consulta.getNome() : imagem.getNome(),
				imagem.getLocalizacaoImagem() == null ? consulta.getLocalizacaoImagem() : imagem.getLocalizacaoImagem(),
				imagem.getProduto() == null ? consulta.getProduto() : produtosService.buscar(imagem.getProduto().getId()).get());
		
		return ResponseEntity.ok().body(imagensService.salvar(paraAtualizar));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		imagensService.deletar(id);
		return ResponseEntity.accepted().build();
	}
	
	private void validaSeProdutoExiste(Imagem imagem) {
		produtosService.buscar(imagem.getProduto().getId());
	}
}
