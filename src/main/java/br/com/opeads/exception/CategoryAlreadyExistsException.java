package br.com.opeads.exception;

public class CategoryAlreadyExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 532464857545875195L;

	public CategoryAlreadyExistsException(String mensagem){
		super(mensagem);
	}
	
	public CategoryAlreadyExistsException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
	
}
