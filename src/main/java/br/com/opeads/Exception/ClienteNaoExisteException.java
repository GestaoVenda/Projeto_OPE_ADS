package br.com.opeads.Exception;

public class ClienteNaoExisteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6896542471254513130L;

	public ClienteNaoExisteException(String mensagem){
		super(mensagem);
	}
	
	public ClienteNaoExisteException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
