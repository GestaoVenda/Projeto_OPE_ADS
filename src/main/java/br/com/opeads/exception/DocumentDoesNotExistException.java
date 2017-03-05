package br.com.opeads.exception;

public class DocumentDoesNotExistException extends RuntimeException {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DocumentDoesNotExistException(String mensagem){
		super(mensagem);
	}

	public DocumentDoesNotExistException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
