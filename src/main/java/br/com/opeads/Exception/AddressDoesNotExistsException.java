package br.com.opeads.Exception;

public class AddressDoesNotExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5489216955775105330L;
	
	public AddressDoesNotExistsException(String mensagem){
		super(mensagem);
	}

	public AddressDoesNotExistsException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
