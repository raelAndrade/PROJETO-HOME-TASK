package br.inpe.embrace.resources.service.impl.exceptions;

/**
 * 
 * @author Israel Andrade
 * 
 * Data de criação 7 de jul de 2019
 */

public class ProdutoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProdutoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
}
