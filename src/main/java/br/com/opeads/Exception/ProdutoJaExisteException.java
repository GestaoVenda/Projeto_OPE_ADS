package br.com.opeads.Exception;

public class ProdutoJaExisteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3393856118651199727L;
	
	public ProdutoJaExisteException(String mensagem){
		super(mensagem);
	}

	public ProdutoJaExisteException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
