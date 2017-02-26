package br.com.opeads.exception;

public class PhoneDoesNotExistsException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2259371482296005136L;

	public PhoneDoesNotExistsException(String mensagem){
		super(mensagem);
	}
	
	public PhoneDoesNotExistsException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
