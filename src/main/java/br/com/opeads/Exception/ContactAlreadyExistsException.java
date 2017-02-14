package br.com.opeads.Exception;

public class ContactAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4046542180658844378L;

	public ContactAlreadyExistsException(String mensagem){
		super(mensagem);
	}
	
	public ContactAlreadyExistsException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
