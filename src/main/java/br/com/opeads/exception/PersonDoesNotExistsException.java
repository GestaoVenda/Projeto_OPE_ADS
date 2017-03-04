package br.com.opeads.exception;

public class PersonDoesNotExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6896542471254513130L;

	public PersonDoesNotExistsException(String mensagem){
		super(mensagem);
	}
	
	public PersonDoesNotExistsException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
