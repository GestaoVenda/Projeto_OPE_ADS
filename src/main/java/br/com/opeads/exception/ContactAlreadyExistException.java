package br.com.opeads.exception;

public class ContactAlreadyExistException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContactAlreadyExistException(String mensagem){
		super(mensagem);
	}
	
	public ContactAlreadyExistException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
