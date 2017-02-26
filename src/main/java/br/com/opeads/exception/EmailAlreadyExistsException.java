package br.com.opeads.exception;


public class EmailAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1720662683039439115L;

	public EmailAlreadyExistsException(String mensagem){
		super(mensagem);
	}
	
	public EmailAlreadyExistsException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
