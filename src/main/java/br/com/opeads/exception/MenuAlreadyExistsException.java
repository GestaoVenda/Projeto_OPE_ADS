package br.com.opeads.exception;

public class MenuAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2912798151805879414L;

	public MenuAlreadyExistsException(String mensagem){
		super(mensagem);
	}
	
	public MenuAlreadyExistsException(String mensagem, Throwable causa){
		super(mensagem,causa);
	}
	
}
