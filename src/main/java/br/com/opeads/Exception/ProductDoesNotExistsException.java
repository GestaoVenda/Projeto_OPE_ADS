package br.com.opeads.Exception;

public class ProductDoesNotExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -530135216256186524L;
	
	public ProductDoesNotExistsException(String mensagem){
		super(mensagem);
	}
	
	public ProductDoesNotExistsException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}

}
