package br.inpe.embrace.application.resource;

import static br.inpe.embrace.application.resource.util.Constants.API;
import static br.inpe.embrace.application.resource.util.Constants.PRODUTOS;
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

import br.inpe.embrace.resources.entities.Produto;
import br.inpe.embrace.resources.service.impl.ProdutoServiceImpl;

/**
 * Classe responsável pela criação dos endpoint dos recursos de produtos
 * 
 * @author Israel Andrade
 * 
 * Data de criação 7 de jul de 2019
 */

@RestController
@RequestMapping(API + V1 + PRODUTOS)
public class ProdutoResource {

	@Autowired
	private ProdutoServiceImpl produtosService;

	@GetMapping
	public ResponseEntity<List<Produto>> exibirProdutos() {
		return ResponseEntity.ok().body(produtosService.listar());
	}

	@GetMapping("{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok().body(produtosService.buscar(id).get());
	}

	@PostMapping
	public ResponseEntity<Produto> salvar(@RequestBody @Valid Produto produto) {
		return ResponseEntity.ok().body(produtosService.salvar(produto));
	}

	@PutMapping
	public ResponseEntity<Produto> atualizar(@RequestBody @Valid Produto produto) throws Exception {

		final Produto consulta = produtosService.buscar(produto.getId()).get();

		final Produto paraAtualizar = Produto.of(consulta.getId(),
				produto.getNome() == null ? consulta.getNome() : produto.getNome(),
				produto.getDescricao() == null ? consulta.getDescricao() : produto.getDescricao());

		return ResponseEntity.ok().body(produtosService.salvar(paraAtualizar));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		produtosService.deletar(id);
		return ResponseEntity.accepted().build();
	}
}
