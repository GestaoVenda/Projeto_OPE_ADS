package br.com.opeads.Exception;

public class CategoriaJaExisteException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 532464857545875195L;

	public CategoriaJaExisteException(String mensagem){
		super(mensagem);
	}
	
	public CategoriaJaExisteException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
	
}
