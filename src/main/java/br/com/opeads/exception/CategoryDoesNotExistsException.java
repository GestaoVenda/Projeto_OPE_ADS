package br.com.opeads.exception;

public class CategoryDoesNotExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -759311526303102515L;
	
	public CategoryDoesNotExistsException(String mensagem){
		super(mensagem);
	}

	public CategoryDoesNotExistsException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
