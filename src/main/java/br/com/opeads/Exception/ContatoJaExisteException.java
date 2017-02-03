package br.com.opeads.Exception;

public class ContatoJaExisteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4046542180658844378L;

	public ContatoJaExisteException(String mensagem){
		super(mensagem);
	}
	
	public ContatoJaExisteException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
