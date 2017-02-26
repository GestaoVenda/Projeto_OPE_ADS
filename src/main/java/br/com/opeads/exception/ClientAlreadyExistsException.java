package br.com.opeads.exception;

public class ClientAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4641570727979583493L;

	public ClientAlreadyExistsException(String mensagem){
		super(mensagem);
	}
	
	public ClientAlreadyExistsException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
