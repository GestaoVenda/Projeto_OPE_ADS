package br.com.opeads.exception;

public class UserDoesNotExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 720706576258495802L;

	public UserDoesNotExistsException(String mensagem){
		super(mensagem);
	}
	
	public UserDoesNotExistsException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
