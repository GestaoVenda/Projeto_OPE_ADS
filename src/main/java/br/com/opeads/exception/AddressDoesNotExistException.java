package br.com.opeads.exception;

public class AddressDoesNotExistException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddressDoesNotExistException(String mensagem){
		super(mensagem);
	}

	public AddressDoesNotExistException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
