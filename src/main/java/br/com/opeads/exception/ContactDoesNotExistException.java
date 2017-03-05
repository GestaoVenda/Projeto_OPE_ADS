package br.com.opeads.exception;

public class ContactDoesNotExistException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContactDoesNotExistException(String mensagem){
		super(mensagem);
	}
	
	public ContactDoesNotExistException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
