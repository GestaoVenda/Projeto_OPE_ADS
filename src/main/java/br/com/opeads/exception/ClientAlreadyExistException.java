package br.com.opeads.exception;

public class ClientAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ClientAlreadyExistException(String mensagem){
		super(mensagem);
	}
	
	public ClientAlreadyExistException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
