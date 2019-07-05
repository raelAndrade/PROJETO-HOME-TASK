package br.inpe.embrace.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.inpe.embrace.domain.Produto;
import br.inpe.embrace.service.impl.ProdutoServiceImpl;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoServiceImpl produtosService; 
	
	@GetMapping
	public ResponseEntity<Produto> exibirProdutos() {
		return null;
	}

}
