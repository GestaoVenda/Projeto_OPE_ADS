package br.com.opeads.Exception;

public class ClienteJaExisteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4641570727979583493L;

	public ClienteJaExisteException(String mensagem){
		super(mensagem);
	}
	
	public ClienteJaExisteException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
