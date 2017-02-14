package br.com.opeads.Exception;

public class ClientDoesNotExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6896542471254513130L;

	public ClientDoesNotExistsException(String mensagem){
		super(mensagem);
	}
	
	public ClientDoesNotExistsException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
