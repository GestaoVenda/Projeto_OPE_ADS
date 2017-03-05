package br.com.opeads.exception;

public class AddressAlreadyExistException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddressAlreadyExistException(String mensagem){
		super(mensagem);
	}
	
	public AddressAlreadyExistException(String mensagem, Throwable causa){
		super(mensagem,causa);
	}
}
