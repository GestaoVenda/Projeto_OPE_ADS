package br.com.opeads.Exception;

public class ContatoNaoExisteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8540854883179031839L;

	public ContatoNaoExisteException(String mensagem){
		super(mensagem);
	}
	
	public ContatoNaoExisteException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
