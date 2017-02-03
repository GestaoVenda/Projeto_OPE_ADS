package br.com.opeads.Exception;

public class EnderecoJaExisteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7033467471822635378L;

	public EnderecoJaExisteException(String mensagem){
		super(mensagem);
	}
	
	public EnderecoJaExisteException(String mensagem, Throwable causa){
		super(mensagem,causa);
	}
}
