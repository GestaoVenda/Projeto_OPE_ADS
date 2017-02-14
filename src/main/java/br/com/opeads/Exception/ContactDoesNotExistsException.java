package br.com.opeads.Exception;

public class ContactDoesNotExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8540854883179031839L;

	public ContactDoesNotExistsException(String mensagem){
		super(mensagem);
	}
	
	public ContactDoesNotExistsException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
