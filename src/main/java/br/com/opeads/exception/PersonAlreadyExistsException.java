package br.com.opeads.exception;

public class PersonAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4641570727979583493L;

	public PersonAlreadyExistsException(String mensagem){
		super(mensagem);
	}
	
	public PersonAlreadyExistsException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
