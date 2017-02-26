package br.com.opeads.exception;

public class AddressAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7033467471822635378L;

	public AddressAlreadyExistsException(String mensagem){
		super(mensagem);
	}
	
	public AddressAlreadyExistsException(String mensagem, Throwable causa){
		super(mensagem,causa);
	}
}
