package br.com.opeads.exception;

public class PhoneAlreadyExistsException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 468826567859168516L;

	public PhoneAlreadyExistsException(String mensagem){
		super(mensagem);
	}
	
	public PhoneAlreadyExistsException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
