package br.com.opeads.Exception;

public class CategoriaNaoExisteException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -759311526303102515L;
	
	public CategoriaNaoExisteException(String mensagem){
		super(mensagem);
	}

	public CategoriaNaoExisteException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
