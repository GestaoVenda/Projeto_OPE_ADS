package br.com.opeads.exception;

public class MenuDoesNotExistsException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 46995375522397478L;

	public MenuDoesNotExistsException(String mensagem){
		super(mensagem);
	}
	
	public MenuDoesNotExistsException(String mensagem, Throwable causa){
		super(mensagem,causa);
	}
}
