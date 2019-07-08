package br.inpe.embrace.resources.service.impl.exceptions;

/**
 * 
 * @author Israel Andrade
 * 
 * Data de criação 7 de jul de 2019
 */
public class ImagemNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ImagemNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
}
