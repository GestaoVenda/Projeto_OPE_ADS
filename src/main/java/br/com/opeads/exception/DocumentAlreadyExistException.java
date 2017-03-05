package br.com.opeads.exception;

public class DocumentAlreadyExistException extends RuntimeException {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DocumentAlreadyExistException(String mensagem){
		super(mensagem);
	}

	public DocumentAlreadyExistException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
