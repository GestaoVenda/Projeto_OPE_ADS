package br.com.opeads.Exception;

public class ProductAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3393856118651199727L;
	
	public ProductAlreadyExistsException(String mensagem){
		super(mensagem);
	}

	public ProductAlreadyExistsException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
