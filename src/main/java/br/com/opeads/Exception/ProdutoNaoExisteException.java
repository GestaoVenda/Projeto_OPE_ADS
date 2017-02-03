package br.com.opeads.Exception;

public class ProdutoNaoExisteException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -530135216256186524L;
	
	public ProdutoNaoExisteException(String mensagem){
		super(mensagem);
	}
	
	public ProdutoNaoExisteException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}

}
