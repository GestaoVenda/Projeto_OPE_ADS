package br.com.opeads.exception;

public class EmailDoesNotExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6131099820334912310L;

	public EmailDoesNotExistsException(String mensagem){
		super(mensagem);
	}
	
	public EmailDoesNotExistsException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
	
}
