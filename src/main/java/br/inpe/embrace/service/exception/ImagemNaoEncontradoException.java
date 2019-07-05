package br.inpe.embrace.service.exception;

public class ImagemNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ImagemNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
}
