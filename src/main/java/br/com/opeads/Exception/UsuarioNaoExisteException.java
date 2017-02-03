package br.com.opeads.Exception;

public class UsuarioNaoExisteException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 720706576258495802L;

	public UsuarioNaoExisteException(String mensagem){
		super(mensagem);
	}
	
	public UsuarioNaoExisteException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
