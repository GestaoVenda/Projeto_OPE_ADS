package br.com.opeads.exception;

public class ClientDoesNotExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ClientDoesNotExistException(String mensagem){
		super(mensagem);
	}
	
	public ClientDoesNotExistException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}

}
